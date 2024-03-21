# Spring MVC
## 1. 원격 프로그램의 실행
### 1. 로컬 프로그램 실행
### 2. 원격프로그램 실행
다른 사람의 컴퓨터에 있는 프로그램 실행

#### 실행방법
서버에 있는 원격 프로그램을 실행하기 위해서는 브라우저와 WAS가 필요하다.
브라우저에서 URL 주소로 요청을 보내면, 톰캣에서 원격으로 프로그램(메서드)를 실행한다.

1. 원격 호출이 가능한 프로그램 등록(@Controller)
2. URL과 메서드를 연결(@RequestMapping)

URL과 연결한 메서드가 private이어도 호출이 가능하다.
@RequestMapping은 외부에서 스프링 프레임워크가 자바의 Reflection API를 이용해서 객체를 생성해 자동으로 메서드를 호출하기 때문이다.
클래스를 돌면서 @Controller와 @RequestMapping 애너테이션을 자동으로 map에 저장한다.

## 2. AWS에 배포하기
프로젝트를 war 파일로 추출해서 Build → Build artifacts

## 3. HTTP 요청과 응답 - 이론

## 4. HTTP 요청과 응답 - 실습

