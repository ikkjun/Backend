# CHAPTER 07 페이지 모듈화와 요청 흐름 제어
## 01 \<jsp:include> 액션 태그를 이용한 공통 영역 작성
방식
1. \<jsp:include> <br>다른 JSP로 실행 흐름을 이동시켜 HTML 실행 결과를 현재 위치에 포함하는 방식
2. \<%@include> <br>다른 파일의 소스 코드를 현재 위치에 삽입한 뒤, JSP파일을 자바 파일로 변환하고 컴파일하는 방식
3. \<include-prelude> <include-coda> <br>코드 조각 자동 포함

화면 구성 요소의 코드 중복 문제를 없앨 때 사용할 수 있는 것이 바로 \<jsp:include> 액션 태그이다.

### 1.1 \<jsp:include> 액션 태그 사용법
```java
<jsp:include page="포함할페이지" flush="false">
```
출력 버퍼를 플러시하면 응답 상태 코드와 HTTP 응답 헤더가 웹 브라우저에 함께 전송된다. 
따라서 flush 속성을 true로 지정하면, 이후로 새로운 헤더 정보를 추가해도 반영되지 않게 된다.
다시 요청을 받아야만 응답으로 보낼 수 있다.

#### 목적 
레이아웃의 한 구성 요소를 모듈화하기 위해 사용된다.
### 1.2 \<jsp:include> 액션 태그를 이용한 중복 영역 처리

### 1.3 \<jsp:param>으로 포함할 페이지에 파라미터 추가하기
```java
<jsp:include page="/module/top.jsp" flush="false">
    <jsp:param name="param1" value="value1"/>
    <jsp:param name="param2" value="value2"/>
</jsp:include>
```
\<jsp:param> 태그는 이미 동일한 이름의 파라미터가 존재하면 기존 파라미터 값을 유지하면서 새로운 값을 추가한다.

## 02 include 디렉티브를 이용한 중복된 코드 삽입
\<jsp:include> 액션 태그는 다른 JSP로 실행 흐름을 이동시켜 실행 결과를 현재 위치에 포함하는 방식인 반면에, include 디렉티브는 다른 파일의 내용을 현재 위치에 삽입한 후에 JSP 파일을 자바 파일로 변환하고 컴파일하는 방식이다.
### 2.1 include 디렉티브의 처리 방식과 사용법
```java
<%@ include file = "포함할 파일" %>
```
### 2.2 include 디렉티브의 활용
#### 목적
- 모든 JSP 페이지에서 사용하는 변수 지정
- 저작권 표시와 같이 모든 페이지에서 중복되는 간단한 문장

### 2.3 코드 조각 자동 포함 기능
```xml
<jsp-config>
    <jsp-property-group>
        <url-pattern>/view/*</url-pattern>
        <include-prelude>/common/variable.jspf</include-prelude>
        <include-coda>/common/footer.jspf</include-coda>
    </jsp-property-group>
</jsp-config>
```
- jsp-property-group: JSP의 프로퍼티를 포함한다.
- url-pattern: 프로퍼티를 적용한 JSP 파일의 URL 패턴을 지정한다.
- <include-prelude>: url-pattern 태그에 지정한 패턴에 해당하는 JSP 파일의 앞에 삽입할 파일을 지정한다.
- <include-coda>: url-pattern 태그에 지정한 패턴에 해당하는 JSP 파일의 뒤에 삽입할 파일을 지정한다.

## 03 \<jsp:forward> 액션 태그를 이용한 JSP 페이지 이동
< jsp:forward> 액션 태그는 하나의 JSP 페이지에서 다른 JSP 페이지로 요청 처리를 전달할 때 사용된다.
1. 웹 브라우저는 from.jsp에 요청을 전달해서 from.jsp는 \<jsp:forward> 액션 태그를 실행한다.
2. 요청 흐름이 to.jsp로 이동하면서 from.jsp에서 사용한 request 기본 객체와 response 기본 객체가 to.jsp로 전달된다.
3. to.jsp가 생성한 결과가 웹 브라우저에 전달된다.

<jsp:forward > 액션 태그를 실행하면 생성했던 출력 결과는 모두 제거된다.
#### \<jsp:forward> 액션 태그를 사용하는 이유
웹 어플리케이션을 개발하다 보면 다양한 조건에 따라 다른 처리를 해야 하는 상황이 발생하는데, 이럴 때 <jsp:forward > 액션 태그를 사용하면 각 조건을 처리하는 JSP를 분리하여 기능별로 모듈화할 수 있게 된다.

### 3.1 \<jsp:forward> 액션 태그의 사용법
```java
<jsp:forward page="이동할 페이지" />
```

#### 실행 결과
- from.jsp에서 <jsp:forward >를 사용해서 이동한 to.jsp가 생성한 결과가 웹 브라우저에 출력된다.
- 웹 브라우저의 주소는 from.jsp 그래도리다. 즉, 리다이렉트처럼 to.jsp로 변경되지 않는다.

### 3.2 \<jsp:forward> 액션 태그와 출력 버퍼와의 관계
실제 웹 브라우저의 출력 결과를 보면 from.jsp가 출력한 내용은 존재하지 않는다. 왜냐하면 <jsp:forward >가 실행되면 출력 버퍼의 내용을 버리고 이동한 페이지의 출력 결과를 출력 버퍼에 저장된다.
또한 <jsp:worward > 액션 태그 뒤에 위치한 코드는 실행조차 되지 않는다.

### 3.3 \<jsp:forward> 액션 태그의 활용
<jsp:forward > 액션 태그를 유용하게 사용할 수 있는 경우는 조건에 따라 다른 결과를 보여줘야 할 때이다.

### 3.4 \<jsp:param> 액션 태그를 이용해서 이동할 페이지에 파라미터 추가하기

## 04 \<jsp:include>와 \<jsp:forward> 액션 태그의 page 속성 경로
<jsp:include >와 <jsp:forward > 액션 태그는 page 속성을 사용해서 포함시키거나 이동할 페이지의 경로를 지정한다.
이 경로는 두 가지 방식으로 입력할 수 있다.
- 웹 어플리케이션 폴더를 기준으로 한 절대 경로
- 현재 JSP 페이지를 기준으로 한 상대 경로

절대 경로는 웹 어플리케이션 폴더를 루트로 사용하는 경로이다. '/'로 시작하면 절대 경로가 된다.
맨 앞의 '/'가 절대 경로의 기준점인 웹 어플리케이션 폴더를 의미한다.

상대 경로는 현재 JSP 페이지를 기준으로 경로를 결정한다. 
```java
../to/to.jsp
```
여기서 ".."은 상위 폴더를 의미한다. 
예를 들어 to 폴더가 chap07 폴더에 포함되어 있다면 chap07 폴더로 이동한 것이다.

절대 경로를 사용하면 관련 파일을 쉽게 찾을 수 있다.
다음의 경우에는 상대 경로를 사용하기도 한다.
- 이동할 페이지가 같은 폴더에 위치한 경우
- 이동할 페이지가 현재 폴더의 하위 폴더에 위치한 경우

## 05 기본 객체의 속성을 이용해서 값 전달하기 
<jsp:param > 액션 태그는 파라미터를 이용해서 데이터를 추가하기 때문에 String 타입의 값만 전달할 수 있다는 제약을 갖는다.
기본 객체의 속성을 이용하면 String 타입을 알맞은 타입으로 변환하는 과정이 필요 없다.
그래서 <jsp:param > 액션 태그를 사용하는 것보다 편리하게 값을 전달할 수 있다.
포함하거나 이동할 페이지는 동일한 요청 범위(request 범위)를 갖기 때문에, request 기본 객체의 속성을 이용해서 필요한 값을 전달할 수 있다.