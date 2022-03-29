# spring-data-security
안정적인 서비스를 위한 Spring Data & Security

---
## 실행 오류
* [build.gradle - Could not find method compile()](https://devdavelee.tistory.com/29)
    * `compile` 대신 `implementation` 수정 후 reload
    * `Gradle` 3.0부터 의존 라이브러리 수정 시 재빌드가 필요한 라이브러리를 선택적으로 할 수 있도록 `compile` x