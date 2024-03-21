# CHAPTER 07 페이지 모듈화와 요청 흐름 제어
## 01 \<jsp:include> 액션 태그를 이용한 공통 영역 작성
방식
1. \<jsp:include> <br>다른 JSP로 실행 흐름을 이동시켜 HTML 실행 결과를 현재 위치에 포함하는 방식
2. \<%@include> <br>다른 파일의 소스 코드를 현재 위치에 삽입한 뒤, JSP파일을 자바 파일로 변환하고 컴파일하는 방식
3. \<include> <br>자동

화면 구성 요소의 코드 중복 문제를 없앨 때 사용할 수 있는 것이 바로 \<jsp:include> 액션 태그이다.

### 1.1 \<jsp:include> 액션 태그 사용법
```java
<jsp:include page="포함할페이지" flush="false">
```
출력 버퍼를 플러시하면 응답 상태 코드와 HTTP 응답 헤더가 웹 브라우저에 함께 전송된다. 
따라서 flush 속성을 true로 지정하면, 이후로 새로운 헤더 정보를 추가해도 반영되지 않게 된다.
다시 요청을 받아야만 응답으로 보낼 수 있다.

### 1.2 \<jsp:include> 액션 태그를 이용한 중복 영역 처리

### 1.3 \<jsp:param>으로 포함할 페이지에 파라미터 추가하기
```java
<jsp:include page="/module/top.jsp" flush="false">
    <jsp:param name="param1" value="value1"/>
    <jsp:param name="param2" value="value2"/>
</jsp:include>
```
\<jsp:param> 태그는 이미 동일한 이름의 파라미터가 존재하면 기존 파라미터 값을 유지하면서 새로운 값을 추가한다.

