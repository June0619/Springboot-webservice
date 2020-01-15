# springboot-webservice

- 2020-01-10
  - 스프링부트와 AWS로 혼자 구현하는 웹 서비스 시작
  - IntelliJ Tool Box 설치 및 프로젝트 세팅
  - Gradle 의존성 주입 및 환경설정
  - JUnit을 통한 테스트코드 작성의 중요성 및 간단한 테스트코드 실습
  - lombok 이용한 Getter 및 생성자 작성

- 2020-01-14
  - Domain 개념
  - 생성자를 이용한 객체 주입
  - PostsApiController -> update Test 실패<br>
  // title update 반영 되지 않음(해결)
- 2020-01-15
  - 오타 수정
  - @RestController 사용시 객체를 JSON으로 변환
  - JSON 변환시 기본 생성자와 GETTER가 없으면 변환 불가
  - 따라서 API응답용 DTO에는 필수적으로 추가해야 함
