# Spring MVC
## 원격 프로그램의 실행
다른 컴퓨터에 있는 객체를 자신의 것처럼 사용하기 위해

원격프로그램 실행방법
1. 프로그램 등록
2. URL과 프로그램을 연결

밖에서 호출하기 때문에 접근제어자가 private이어도 된다. 
Spring이 Reflection API로 자동화해서 객체도 원할 때 생성할 수 있다.
클래스를 돌면서 애너테이션과 controller를 자동으로 map에 등록한다.

## HTTP 요청과 실습
### 1. HttpServletRequest
편지는 브라우저가 써서 톰캣이 요청을 받는다.
톰캣은 편지를 request라는 객체로 전환한다.
여러 정보를 묶은 것이 객체이다.

메서드는 내가 실행할 것은 이런 것이라서 어떤 것이 필요한지 정의한 것이다.
이 때 매개변수는 필요한 것을 적는다.

### 2. HttpServletRequest의 메서드
브라우저가 직접 요청을 만들어 준다

요청하는 방법
1. url 직접 입력
2. a 태그에 입력
3. form 태그에 입력

getQueryString() → name은 key, value는 value의 형태로 map에 저장된다.<br>
원래 String과 String 배열이 map에 들어가 있다. 여러 개의 값을 받을 수 있기 때문이다.

### 3. 클라이언트와 서버
- 클라이언트(client): 서비스를 요청하는 애플리케이션
- 서버(server): 서비스(service)를 제공하는 애플리케이션

## 클라이언트와 서버
### 2. 서버의 종류
- Email server
- File servet
- Web server
WAS: 다른 서버에 있는 것을 내 컴퓨터처럼 실행하는 것

### 3. 서버의 포트
포트로 서버를 결정한다. 포트와 프로그램을 연결하는 것을 바인딩이라고 한다.

URI(uniform resource location)<br>
resource의 종류
- 정적: 파일 ← Web Server
- 동적: 프로그램 관리 ← Web Application Server(WAS)

### 4. 웹 어플리케이션 서버(WAS)란?
웹 어플리케이션을 서비스하는 서버<br>
application = 프로그램
web application = 브라우저를 통한 서비스

### 5. Tomcat의 내부 구조
브라우저에서 요청을 보내면 톰캣의 서버 중에서 하나의 쓰레드가 받아서 서비스르르 한다.
프로토콜을 이용해서 HTTP와 연결을 한다.
한 개의 서버에 여러 개의 서블릿이 있다.

### 6. Tomcat의 설정 파일 - server.xml, web.xml
- 톰캣설치경로/conf/server.xml: Tomcat 서버 설정 파일
- 톰캣설치경로/conf/web.xml: Tomcat의 모든 web app의 공통설정
- 웹앱이름/WEB-INF/web.xml: web app의 개별 설정


