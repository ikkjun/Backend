# CHAPTER 06 에러 처리
## 01 익셉션 직접 처리하기
에러 화면을 노출하고 싶지 않다면 try-catch를 이용해서 익셉션이 발생할 때 알맞은 응답을 생성할 수 있다.
## 02 에러 페이지 지정하기
익셉션이 발생하면 보여줄 JSP 페이지는 page 디렉티브의 errorPage 속성을 사용해서 지정할 수 있다.
## 03 에러 페이지 작성하기
에러 페이지에 해당하는 JSP 페이지는 page 디렉티브의 isErrorPage 속성의 값을 "true"로 지정해야 한다.
에러 페이지로 지정된 JSP는 exception 기본 객체를 사용할 수 있다.
## 04 응답 상태 코드별로 에러 페이지 지정하기
에러 코드에 대해 보여줄 에러 페이지를 지정하려면 web.xml 파일에 다음과 같은 설정을 추가해주면 된다.
```java
<?xml version="1.0" encoding="UTF-8"?>
<web-app ...>
    ...
    <error-page>
        <error-code>에러코드</error-code>
        <location>에러페이지의 URI</location>
    </error-page>
</web-app>
```

웹 어플리케이션에서 많이 발생하는 에러 코드는 404와 500이다.
404 응답 코드는 사용자가 잘못되거나 존재하지 않는 URL을 입력했을 때 사용되며, 500 응답 코드는 JSP 코드를 잘못 작성했거나 서버에서 예상하지 못한 에러가 발생했을 때 사용된다.

## 05 익셉션 타입별로 에러 페이지 지정하기
JSP페이지에서 발생하는 익셉션 종류별로 에러 페이지를 지정할 수도 있다.
<error-code> 태그 대신에 <exception-type> 태그를 사용하면 된다.
```java
<?xml version="1.0" encoding="UTF-8"?>
<web-app ...>
    ...
    <error-page>
        <exception-type>에러코드</exception-type>
        <location>에러페이지의 URI</location>
    </error-page>
</web-app>
```

응답 상태 코드보다 예외 종류를 선언한 것이 우선순위가 더 높다.