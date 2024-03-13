# CHAPTER 03 JSP로 시작하는 웹 프로그래밍
## 01 JSP에서 HTML 문서를 생성하는 기본 코드 구조
일반적인 JSP코드 = JSP 페이지에 대한 정보를 입력하는 설정 부분 + HTML 문서를 생성하는 부분
- JSP 페이지에 대한 정보를 입력하는 설정 부분
  - JSP 페이지가 생성하는 문서의 타입(종류)
  - JSP 페이지에서 사용할 커스텀 태그
  - JSP 페이지에서 사용할 자바 클래스 지정<br>

캐릭터 셋(character set)은 문자정보 데이터베이스로서 문자 집합을 정의한 Unicode와 같ㄷ다.
Unicode를 부호화(encoding) 한 것이 인코딩(UTF-8, UTF-16, UTF-32)이다.
<%@ page ... %>를 page 디렉티브라고 하는데, JSP 페이지에 대한 정보를 설정할 때 page 디렉티브를 사용한다.

## 02 JSP 페이지의 구성 요소
- 디렉티브(Directive)
- 스크립트: 스크립트릿(Scriptlet), 표현식(Expression), 선언부(Declaration)
- 표현 언어(Expression Language)
- 기본 객체(Implicit Object)
- 정적인 데이터
- 표준 액션 태그(Action Tag)
- 커스텀 태그(Custom Tag)와 표준 태그 라이브러리(JSTL)

## 03 page 디렉티브
```java
<%@ page contentType="text/html; charset=urf-8"%>
<%@ page import="java.uril.Date"%>
```
### 3.1 contentType 속성과 캐릭터 셋
contentType은 JSP가 생성할 문서의 MIME 타입을 입력한다. MIME(Multipurpose Internet Mail Extensions)은 이메일의 내용을 설명하기 위해 정의되었다. 
하지만 메일뿐만 아니라 HTTP 등의 프로토콜에서도 응답 데이터의 내용을 설명하기 위해서 MIME를 사용하고 있다.

contentType 속성의 값 중에서 "; charset=캐릭터 셋" 부분은 생략할 경우 기본 캐릭터 셋인 ISO-8859-1을 사용하게 된다.
그러나 영어와 서유럽어의 문자만 포함하고 있는 ISO-8859-1로는 한글을 제대로 표현할 수 없기 때문에 EUC-KR이나 UTF-8과 같이 한국어를 포함하고 있는 캐릭터 셋을 사용해야 한다.

### 3.2 import 속성
import 속성의 사용방법
```java
<%@ page import = "java.util.Calendar"%>
<%@ page import = "java.util.Date"%>
```
또는 
```java
<%@ page import = "java.util.Calendar, java.util.Date"%>
```

### 3.3 trimDirectiveWhitespaces 속성을 이용한 공백 처리
서블릿 파일을 실행한 뒤 웹 브라우저에서 소스 보기를 하면 첫 줄에 빈줄이 생성된다.
이 첫줄의 공백은 page 디렉티브가 있던 위치에서 만들어진 것이다.
trimDirectiveWhitespaces 속성의 값을 true로 지정하면 디렉티브나 스크립트 코드 위치에서 발생하는 줄바꿈 공백 문자를 제거해준다.