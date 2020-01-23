# springboot-webservice

### Plugins
    - mustache
    - lombok
    - Database Navigator

### Update
* 2020-01-10
  - 스프링부트와 AWS로 혼자 구현하는 웹 서비스 시작
  - IntelliJ Tool Box 설치 및 프로젝트 세팅
  - Gradle 의존성 주입 및 환경설정
  - JUnit을 통한 테스트코드 작성의 중요성 및 간단한 테스트코드 실습
  - lombok 이용한 Getter 및 생성자 작성

* 2020-01-14
  - Domain 개념
  - 생성자를 이용한 객체 주입
  - PostsApiController -> update Test 실패<br>
  // title update 반영 되지 않음(해결)

* 2020-01-15
  - 오타 수정
  - @RestController 사용시 객체를 JSON으로 변환
  - JSON 변환시 기본 생성자와 GETTER가 없으면 변환 불가
  - 따라서 API응답용 DTO에는 필수적으로 추가해야 함

* 2020-01-16
    - 서버 템플릿 엔진과 클라이언트 템플릿의 차이
    - 머스테치 기본 사용 방법
    - css -> header / js -> footer 포함시키는 이유
    - js 객체를 이용해 전역 변수 충돌문제 회피
    - CRUD 구현과 delete Test 코드 자체 작성
    - <참조> git ignore 작동하지 않을때 대응 방법<br>
    https://jojoldu.tistory.com/307
    - OAUTH2.0을 이용한 로그인 api 생성<br>
* 2020-01-20
    - Naver Login API 등록 (해결)
        - Invalid Token
        - Annotation을 이용해 Session 값 받을 시 NullPointException<br>
        // WebConfig Class의 addArgumentResolvers 메소드명 오타(override 되지 않음)
        
* 2020-01-21     
    - Spring Security 적용으로 기존 Test Code 인증 문제 해결
    - Session 저장소로 톰캣 / DB / 메모리 DB 등이 있고 이 중 DB를 사용하는 이유
    - ArgumentResolver 를 통해 어노테이션으로 로그인 세션 정보 가져오기
    - Layout 약간 수정
    - EC2 인스턴스 생성 / 탄력적 IP 할당
    - pem 키 관리 방법
    - 리눅스 서버 생성 및 호스트네임 설정
* 2020-01-22
    - AWS RDS 개념과 생성 방법
    - RDS 서비스를 위한 여러 파라미터 설정
    - Intellij 에서 DB를 다루는 방법
    - EC2와 RDS 연동  
* 2020-01-23
    - EC2 서버에 프로젝트 배포
    - linux os 쉘 스크립트 이용 방법
    - 스프링 부트 프로젝트와 RDS 연동
    - 배포 과정에서 db driver 읽지 못하는 문제 있음
  