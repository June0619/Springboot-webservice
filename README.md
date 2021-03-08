# springboot-webservice

### Plugins
    - mustache
    - lombok
    - Database Navigator

### Update
* 2020-01-10
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
  - @RestController 사용시 객체를 JSON으로 반환
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
* 2020-01-28
    - DB Driver 인식하지 못하는 문제 해결
        - linux os 상에서 gradlew -x 권한 부여하지 않아 빌드가 제대로 되지 않았던게 원인
        - 권한 부여 후 빌드한 뒤 정상적으로 작동 됨
    - 현재는 ec2 서버상에서 구동중 아래 DNS로 접속 가능
    - http://ec2-15-165-89-64.ap-northeast-2.compute.amazonaws.com:8080/
* 2020-01-30
    - travis CI / aws code deploy 연동하여 코드 push 시 자동으로 배포 구성
        - 현재 ec2 서버 경로에는 배포 파일이 전송 되지만 쉘스크립트가 작동하지 않는 문제가 있음<br>
        // deploy.sh 실행 권한을 부여받지 못하는것으로 보임
* 2020-01-31
    - 배포 자동화 구성 완료
        - 위의 문제는 deploy.sh 스크립트 명령어 오류로 jar 실행코드가 실시되지 않고 있었음.
    - 서버 배포시 오류 로그 확인 방법
        - /opt/codedeploy-agent/deployment-root/deployment-logs 로그 확인
        - /var/log/aws/codedeploy-agent/ 로그 확인
    - 새로운 Jar 실행 시 기존 Jar 종료되는 문제를 해결하기 위한 무중단 배포 시스템 구축
        - EC2 서버 상에 nginx install
        - nginx 사용을 위한 profile security config 및 test code 작성
        - 어플리케이션이 실행중인지 확인 / 교체 / 종료를 진행하는 쉘스크립트 작성
* 2020-02-03
    - linux 상에서 현재 실행중인 어플리케이션 추적 : ps -ef | grep java
    - nginx 를 이용한 무중단 배포 중 heath check 실패 문제(해결)
        - health check 실패로 배포 로그에 time out 에러가 찍힘
        - 배포 과정자체는 실행되지만 health check 실패로 프록시 스위칭이 진행되지 않고 8081포트로만 배포가 진행됨
        - ProfileController realProfiles 리스트 오타로 인해 health check 상에서 real1 프로필 체크가 불가능했던것이 원인이었음.         
    - nginx 상에서는 port 8082로 교체 진행되나 로그 상에는 8081 포트로 실행되는 문제 발견
        - 쉘 스크립트상 오타가 원인이었음
    - 무중단 배포까지 문제없이 작동 확인
        - http://ec2-15-165-89-64.ap-northeast-2.compute.amazonaws.com
* 중간 목표
    - 내부 로직 복습
    - 프론트 추가
    - Domain
    - 권한 재설정

* 2020-02-07
    - mustache 템플릿 상에서 세션 값을 사용하려면 properties 파일에 별도 설정이 필요함
        - spring.mustache.expose-session-attributes=true
    - CSS & template 수정 중...
        - Test Code 수정 필요
  
