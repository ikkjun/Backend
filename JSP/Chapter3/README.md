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