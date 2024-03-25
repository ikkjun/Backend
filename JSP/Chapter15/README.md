# CHAPTER 15 웹 어플리케이션의 일반적인 구성 및 방명록 구현
## 01 웹 어플리케이션의 전형적인 구성 요소
중복된 콛를 만들지 않는 여러 가지 방법 중 하나는 화면을 보여주기 위한 코드와 상관없이 사용자의 요청을 처리하는 코드를 별도 클래스로 분리하는 것이다.
또한 DB 처리와 같이 여러 기능에서 사용될 수 있는 코드를 별도 클래스로 분리하기도 한다.

### 1.1 웹 어플리케이션 주요 구성 요소
- Service 클래스: 사용자의 요청을 처리하는 기능을 제공한다.
- DAO 클래스: DB와 관련된 쿼리를 실행한다.
- JSP(뷰): Service 클래스가 실행한 결과를 화면에 출력하거나 Service가 기능을 수행하는 데 필요한 데이터를 전달한다.
- MVC 프레임워크: 사용자의 요청을 Service에 전달하고 Service의 실행결과를 JSP와 같은 뷰에 전달한다.

### 1.2 데이터 접근 객체(Data Access Object)의 구현
DAO 클래스는 데이터에 접근할 때 사용하는 객체를 위한 클래스를 의미한다.<br>
DAO 클래스가 제공하는 메서드:<br> 
- insert()
- select()
- update()
- delete()

#### 1.2.1 DAO에서 Connection에 접근하는 방식
DAO가 쿼리를 실행하려면 Statement나 PreparedStatement가 필요한데, 이 두 객체는 Connection 객체로부터 구할 수 있다.

Connection 객체를 구하는 방법
- DAO 클래스의 메서드에서 직접 Connection을 생성
- DAO 객체를 생성할 때 생성자로 Connection을 전달받기
- DAO 클래스의 메서드 파라미터로 Connection을 전달받기