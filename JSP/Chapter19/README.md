# CHAPTER 19 필터
## 01 필터란 무엇인가
필터는 'HTTP' 요청과 응답을 변경할 수 있는 재사용 가능한 클래스이다. 필터는 객체의 형태로 존재하며 클라이언트에서 오는 요청(request)과 최종 자원 사이에 위치하여 클라이언트의 요청 정보를 알맞게 변경할 수 있다.
또한 플터는 최종 자원과 클라이언트로 가는 응답(response) 사이에 위치하여 최종 자원의 요청 결과를 알맞게 변경할 수도 있다.

## 02 필터의 구현
- javax.servlet.Filter 인터페이스
- javax.servlet.ServletRequestWrapper 클래스
- javax.servlet.ServletResponseWrapper

### 2.1 Filter 인터페이스
Filter 인터페이스가 가지고 있는 메서드
- public void init(FilterConfig filterConfig) throws ServletException<br>필터를 초기화할 때 호출된다.
- public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException<br>필터 기능을 수행한다. chain을 이용해서 체인의 다음 필터로 처리를 전달할 수 있다.
- public void destory(): 필터가 웹 컨테이너에서 삭제될 때 호출된다.

Filter 인터페이스의 doFilter() 메서드는 요청이 있을 때마다 매번 실행된다. 요청을 필터링 한 필터 객체가 또 다시 응답을 필터링한다.

### 2.2 필터 설정하기: web.xml 이용
### 2.3 필터 설정하기: @WebFilter 어노테이션 사용