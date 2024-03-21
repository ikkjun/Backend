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