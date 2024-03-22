# CHAPTER 11 표현 언어(Expression Language)
표현 언어(Expression Language)는 다른 형태의 스크립트 언어로서 스크립트 요소 중의 하나이다.

## 01 표현 언어란?
표현 언어(Expression Language)는 값을 표현하는 데 사용하는 스크립트 언어로, JSP의 스크립트 요소를 보완하는 역할을 한다.

```java
<%-- 표현식 --%>
<%= member.getAddress().getZipcode() %>

<%-- 표현 언어 --%>
${member.address.zipcode}
```

### 1.1 EL의 구성
EL은 $와 괄호({, }) 그리고 표현식을 사용하여 값을 표현한다.
```java
${expr}
```
EL은 JSP의 스크릷트 요소(스크립트릿, 표현식, 선언부)를 제외한 나머지 부분에서 사용될 수 있으며, EL을 통해서 표현식보다 편리하게 값을 출력할 수 있다.
