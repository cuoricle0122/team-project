# 🏨 호캉스홀릭(가제)
    호텔 숙박을 예약할 수 있는 온라인 서비스, 호캉스홀릭입니다.

# 💻 프로젝트 개요
    호캉스홀릭은 2023년 9월 14일부터 10월 11일까지
    약 한 달 동안 개발된 프로젝트입니다.
    팀은 총 4명으로 구성되었으며, 각자 다른 역할을 맡아
    프로젝트를 개발을 진행하였습니다.

# 💻 프로젝트 설명
    호캉스홀릭은 이 플랫폼에 가입한 회원이 손쉽게 호텔 예약을
    할 수 있도록 도와주는 웹 기반 서비스입니다.
    사용자는 다양한 필터링 옵션을 통해 자신의 조건에 맞는 숙소를 찾고,
    최적의 검색결과를 바탕으로 실시간 예약이 가능합니다.
    또한, 다양한 호캉스 패키지 정보와 리뷰를 함께 제공하여
    보다 만족할 수 있는 선택을 하도록 돕습니다.

# 💻 개발 환경 및 사용된 기술
    (추후 작성 예정)

# 💻 설계 고려사항 정리
    1. 사용자 인증 및 권한 관리
        - 사용자의 로그인 및 회원가입 지원
        - 로그인 사용자 / 비로그인 사용자 구분
        - 권한 수준 나누어 관리자, 호텔 및 일반 사용자를 구분

    2. 호텔 및 객실 관리
        - 호텔 정보를 저장 및 호텔 내 객실 정보 저장
        - 객실 유형과 가격 등을 구분하여 관리

    3. 예약 및 결제 처리
        - 객실을 선택 및 예약
        - 결제 처리를 위한 외부 결제 서비스를 연결

    4. 예약 관리 기능
        - 로그인 사용자가 예약한 예약 목록 및 예약 목록별 상세 정보를 제공
        - 일정 시간별 예약 상태를 업데이트 (구현 가능 불확실)
        - 예약 취소 기능

    5. 검색 및 필터링 기능
        - 사용자가 원하는 기준에 따라 필터링할 수 있는 검색 기능
        - 지역, 가격, 객실 유형, 평점 등의 필터링 옵션

    6. 사용자 알림 기능
        - 예약 알림, 예약 상태 변경 등 예약관련 알림
        - 프로모션 및 특별 이벤트 알림
    
    7. 사용자 데이터 보안
        - 사용자의 개인정보 보호 및 데이터 보안
        - 결제 정보 보안

    8. 트래픽 관리 및 성능 최적화
        - 점차 늘어나는 트래픽 및 호텔 데이터를 처리할 수 있도록
          시스템을 최적화하고 확장 가능하도록 설계 ( 어떻게... ? )

    9. DB(데이터베이스) 모델링
        - 호텔, 객실, 예약 및 사용자 등의 주요 엔티티를 모델링하고 관계를 정의
        참고) 엔터티 = 객체 
        - DB모델링 가능한지 아직 불확실
    
    10. API 지원
        - 지도 서비스(API)를 활용하여 호텔 위치를 안내
        - 호캉스홀릭에 등록된 업체 지도상에 표기
        - 현재 위치 기반 가장 가까운 호텔 안내

    11. 프론트엔드 및 UI 개발

# 💻 프로젝트 구조
    ◎ config (설정 클래스)
        - SecurityConfig (보안 설정)
        - MvcConfig (Spring MVC 설정)

    ◎ controller (웹 컨트롤러)
        - UserController (사용자 관련 컨트롤러)
            → 사용자 관련 웹 컨트롤러
            → 사용자 로그인, 회원가입, 프로필 페이지 표시
        - HotelController (호텔 관련 컨트롤러)
            → 호텔 관련 웹 컨트롤러
            → 호텔 목록 표시, 호텔 상세 정보 표시
        - ReservationController (예약 관련 컨트롤러)
            → 예약 관련 웹 컨트롤러
            → 객실 예약, 예약 취소, 예약 목록 표시

    ◎ dto (DTO 및 데이터 모델 클래스)
        - UserDto (사용자 관련 DTO)
        - HotelDto (호텔 관련 DTO)
        - ReservationDto (예약 관련 DTO)
        → 컨트롤러와 서비스 간 데이터 교환

    ◎ entity (JPA 엔터티 클래스)
        - User (사용자 엔터티)
        - Hotel (호텔 엔터티)
        - Room (객실 엔터티)
        - Reservation (예약 엔터티)
        → MySQL 내 데이터베이스 테이블과의 매핑 목적

    ◎ repository (JPA 리포지토리 인터페이스)
        - UserRepository (사용자 리포지토리)
        - HotelRepository (호텔 리포지토리)
        - RoomRepository (객실 리포지토리)
        - ReservationRepository (예약 리포지토리)
        → MySQL 내 엔터티에 접근가능한 메서드를 구현

    ◎ service (서비스 로직 클래스)
        - UserService (사용자 서비스)
        - HotelService (호텔 서비스)
        - ReservationService (예약 서비스)
        → 해당 클래스에 관련된 비즈니스 로직 구현
        → 리포지토리 패키지를 이용하여 데이터를 읽고 쓰기
        → 컨트롤러 패키지를 이용하여 비즈니스 로직 실현

# 개발시 참고사항 ( 추후 삭제 예정 )
    ㅇ CONTROLLER 패키지:
    프로젝트의 웹 애플리케이션에서 클라이언트의 HTTP 요청 처리 및 응답 생성.
    호텔 예약 애플리케이션에서 사용자가 호텔을 예약하는
    요청을 처리하는 컨트롤러를 정의

    ㅇ DTO 패키지 설계 목적
    프로젝트에서 사용자 입력 데이터를 수신하거나
    서비스로부터 반환되는 데이터를 전송하는데 사용되는 클래스.
    사용자가 웹 페이지에서 입력한 데이터를 컨트롤러에서 DTO로 수신한 다음,
    서비스로 전달하여 처리하기 위함

    ㅇ ENTITY 패키지 설계 목적
    프로젝트의 핵심 데이터 모델을 정의.
    호텔 예약 시스템에서 호텔, 객실, 예약 및 사용자와 같은
    중요한 개념을 엔터티 클래스로 표현

    ㅇ REPOSITORY 패키지 설계 목적
    프로젝트에서 데이터베이스와의 상호 작용을
    처리하기 위한 인터페이스와 메서드를 제공.
    호텔 정보를 검색하고 저장하기 위한 호텔 리포지토리를 정의.

    ㅇ SERVICE 패키지 설계 목적
    프로젝트에서 비즈니스 로직을 구현,
    컨트롤러로부터 데이터를 받아 처리,
    리포지토리를 사용하여 데이터베이스와 상호 작용.
    호텔 예약 로직을 처리하는 호텔 서비스를 정의

# 💻 설치 및 사용 방법
    웹 기반 서비스로 별도 설치가 필요없으며 <www.hocanceholic.com>에 접속 후
    간단한 가입을 통해 호캉스홀릭을 바로 이용하실 수 있습니다.

# 📞 연락처 정보
    웹사이트의 문제점이나 기타 문의사항, 협업 요청 등은
    아래 메일로 연락주시기 바랍니다.

    💌 백종엽 / keyba3407@naver.com
    💌 김지은 / zzzz3311@naver.com
    💌 이재호 / cuoricle0122@nate.com
    💌 김은채 / rladmsco7734@naver.com

# 🙏 감사의 글
    이 서비스는 다양한 피드백과 관심을 통해 발전이 가능합니다.
    많은 이용 부탁드립니다.