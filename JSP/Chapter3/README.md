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

### 3.4 JSP 페이지의 인코딩과 pageEncoding 속성
JSP 파일을 읽을 때는 page 디렉티브의 pageEncoding 속성과 contentType 속성을 사용해서 캐릭터 인코딩을 결정한다.

BOM(Byte Order Mark)은 UTF-8, UTF-16, UTF-32와 같은 유니코드 인코딩에서 바이트의 순서가 리틀 엔디언(Little Endian)인지 빅 엔디언(Big Endian)인지의 여부를 알려주는(mark) 16비트(2바이트) 값이다.

파일이 유니코드가 아니거나 파일이 BOM으로 시작하지 않을 경우, 먼저 pageEncoding 속성을 검색하고 그 다음에 contentType 속성의 charset의 값을 검색하게 된다.
따라서 pageEncoding 속성을 지정하지 않은 상태에서 contentType 속성의 charset의 값을 잘못 지정하면 잘못된 인코딩을 이용해서 파일을 읽어오게 되며, 이는 문자가 깨져서 출력되는 원인이 된다.
pageEncoding속성에 지정한 인코딩과 contentType 속성에 지정한 인코딩이 서로 다를 수도 있다.
JSP 파일은 UTF-8로 작성하고 응답 결과는 EUC-KR로 생성하고 싶다면, pageEncoding 속성은 "utf-8"로 지정하고 contentType 속성의 charset은 "euc-kr"로 지정하면 된다.

## 04 스크립트 요소
JSP의 스크립트 요소는 다음의 세 가지가 있다.
- 스크립트릿(Scriptlet)
- 표현식(Expression)
- 선언부(Declaration)

### 4.1 스크립트릿
스크립트릿(scriptlet)은 JSP 페이지에서 자바 코드를 실행할 때 사용하는 코드 블록이다. 
```java
<%
    자바코드1;
    자바코드2;
    자바코드3;
%>
```
스크립트릿의 코드 블록은 '<%'로 시작해서 '%>'로 끝나며, '<%'와 '%>' 사이에는 실행할 자바 코드가 위치한다.

### 4.2 표현식
표현식(Expression)은 어떤 값을 출력 결과에 포함시키고자 할 때 사용된다.
표현식은 '<%='로 시작해서 '%>'로 끝나며, 이 둘 사이에는 출력할 값이 위치한다.
```java
<%= 값 %>
```

### 4.3 선언부
JSP 페이지의 스크립트릿이나 표현식에서 사용할 수 있는 메서드를 작성할 때에는 선언부(declaration)를 사용한다.
```java
<%
    public 리턴타입 메서드이름(파라미터목록) {
        자바코드1;
        자바코드2;
        ...
        자바코드n;
        return 값;
    }
%>
```

## 05 request 기본 객체
웹 브라우저에 웹 사이트의 주소를 입력하면, 웹 브라우저는 해당 웹 서버에 연결한 후 요청 정보를 전송하는데, 
이 요청 정보를 제공하는 것이 바로 request 기본 객체(생성을 안 해도 쓸 수 있다)이다.

request 기본 객체가 제공하는 기능
- 클라이언트(웹 브라우저)와 관련된 정보 읽기 기능
- 서버와 관련된 정보 읽기 기능
- 클라이언트가 전송한 요청 파라미터 읽기 기능
- 클라이언트가 전송한 요청 헤더 읽기 기능
- 클라이언트가 전송한 쿠키 읽기 기능
- 속성 처리 기능

### 5.1 클라이언트 정보 및 서버 정보 읽기
request 기본 객체는 웹 브라우저, 즉 클라이언트가 전송한 정보와 서버 정보를 구할 수 있는 메서드를 제공하고 있다.

### 5.2 요청 파라미터 처리
#### 5.2.1 HTML 폼과 요청 파라미터 
HTML <form>의 각 입력요소는 name 속성의 값이 입력 요소의 이름이 된다.
입력 요소의 이름은 웹 브라우저가 서버에 전송하는 요청 파라미터의 이름으로 사용된다.