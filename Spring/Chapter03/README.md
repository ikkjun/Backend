# Spring DI와 AOP
## Spring DI 흉내내기
### 1. 변경에 유리한 코드(2) - Map과 외부 파일
파일에 적힌 것을 읽어서 쓴다. 
그래서 파일만 변경하면 된다.
객체로 변경되어서 Map에 저장된다.
Map으로 관리하는 이유? 재사용성 높이고 관리가 용이하게 하기 위해.

injection: 만들어서 넣어준다.

Map: key나 value를 뒤져서 찾는다
이력: 객체 → instanceof

### 3. 자동 객체 등록하기 - Component Scanning
하나의 Component이다. 
Rule: 클래스의 첫 글자를 소문자로 해서 키로 쓴다.
- 객체를 찾는 방법: id로 찾기
- 타입으로 찾기(Car.class): instanceof로 찾기

@Autowired는 Map에서 Type으로 찾는다. 알아서 찾아서 해라

## Spring DI 활용하기 - 이론
### 1. 빈(bean)이란? 
Spring container가 관리하는객체
Spring container: 객체 저장소 = map
왜 담아? 재사용하려고

1. BeanFactory: 부무
2. ApplicationContext - BeanFactory를 확정해서 여러 기능을 추가

AC(Application Context)
|XML |Java coding |
rootAC 생성할 때 필요한 것은 성성 파일
root: param: value

### 2. Root AC와 Servlet AC
attribute: 전체에서 쓸 수 있다.(전역 번수)

jsp scope: page, request, session, application
key로 접근하는 방법

children
content 안에 일다.