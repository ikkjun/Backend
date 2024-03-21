# CHAPTER 07 페이지 모듈화와 요청 흐름 제어
## 01 \<jsp:include> 액션 태그를 이용한 공통 영역 작성
방식
1. \<jsp:include> <br>HTML 결과 포함
2. @include <br>소스 포함
3. \<include> <br>자동

화면 구성 요소의 코드 중복 문제를 없앨 때 사용할 수 있는 것이 바로 \<jsp:include> 액션 태그이다.

### 1.1 \<jsp:include> 액션 태그 사용법
```java
<jsp:include page="포함할페이지" flush="false">
```
출력 버퍼를 플러시하면 응답 상태 코드와 HTTP 응답 헤더가 웹 브라우저에 함께 전송된다. 따라서 flush 속성을 true로 지정하면, 이후로 새로운 헤더 정보를 추가해도 반영되지 않게 된다.
따라서 flush 속성을 true로 지정하면 이후로 새로운 헤더 정보를 추가해도 반영되지 않게 한다.
