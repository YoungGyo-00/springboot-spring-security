# spring-data-security
안정적인 서비스를 위한 Spring Data & Security

---
## 필요 개념
### Spring Security
* 스프링 기반의 어플리케이션 보안을 담당하는 프레임워크

### Servlet Container
* `Tomcat`과 같은 웹 애플리케이션을 서블릿 컨테이너
* 필터 체인 -> 모든 request는 반드시 거쳐야함
![Servlet Container - Filter Chain](./image/ServletContainer.png)


### Security Filters
* 스프링 시큐리티는 메인 필터 아래, `SecurityFilterChain` 그룹을 등록
* 필터 체인은 반드시 한개 이상, url 패턴에 따라 다르게 적용할 수 있음.
![Security Filters](./image/SecurityFilters.png)


### Authentication Structure
* 로그인 -> `authenticated == true` 인 `Authentication` 객체를 `SecurityContext`에 갖고 있는 상태
* `AuthenticationManager`를 통해 `Authentication` 인증 -> `SecurityContextHolder`
![AuthenticationStructure](./image/AuthenticationStructure.png)
## 실행 오류
* [build.gradle - Could not find method compile()](https://devdavelee.tistory.com/29)
    * `compile` 대신 `implementation` 수정 후 reload
    * `Gradle` 3.0부터 의존 라이브러리 수정 시 재빌드가 필요한 라이브러리를 선택적으로 할 수 있도록 ~~compile~~