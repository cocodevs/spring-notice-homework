# 공지사항 게시판 구현
- 공지사항 CRUD
- 회원가입 
- 로그인

# Backend
- Java 1.8
- Spring Boot
- JPA
- H2
- Spring Security
- JUnit5
  
# Frontend
- thymeleaf
- javascript
- css, bootstrap

---
# 테이블 설계
- MEMBER 회원 테이블
- POST 게시글 테이블
- POST_FILE 게시글 첨부파일 테이블
- https://dbdiagram.io/d/60f8e4614ed9be1c05d7403c

<img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img1.png" width="700px">


----
# PAGE & API 
|기능|Method|URL|Return Page|
|------|---|---|---|
|공지사항 전체 조회|GET|/posts|전체 공지사항 조회|
|공지사항 등록 페이지|GET|/posts/create-form|공지사항 등록 페이지로 이동|
|공지사항 수정 페이지|GET|/posts/modify-form|공지사항 수정 페이지로 이동|
|공지사항 상세 조회|GET|/posts/{id}|공지사항 조회 페이지로 이동 및 조회|
|공지사항 등록|POST|/posts|공지사항 등록 및 목록으로 이동|
|공지사항 수정|PUT|/posts/{id}|공지사항 수정 및 목록으로 이동|
|공지사항 삭제|DELETE|/posts/{id}|공지사항 삭제 및 목록으로 이동|

# 실행 방법

- 해당 프로젝트 clone
> $ git clone https://github.com/cocodevs/spring-notice-homework.git [DIR]

<br>

- h2 db가 없다면
> $ brew install h2

<br>

> RsupportHomeworkApplication 실행

<br>

> resources/import.sql로 최초 데이터 insert

<br>

> 관리자 ID: admin@rsupport.com / PW: 1234
> 
> 사용자 ID: cocodev@naver.com / PW: 1234

---

# 실행 화면
> #### 메인화면 
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img2.png" width="700px">

> #### 로그인 화면
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img3.png" width="700px">

> #### 로그인 필수값 미입력
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img4.png" width="700px">

> #### 로그인 계정 정보 불일치
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img5.png" width="700px">

> #### 회원가입 화면
> - 이메일, 이름, 비밀번호, 비밀번호 확인 입력
> - validation check 후 회원가입 가능
> 
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img7.png" width="700px">

> #### 이미 존재하는 아이디로 회원가입 요청
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img8.png" width="700px">

> #### 정상 회원가입 후 메인 화면으로 이동
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img9.png" width="700px">

> #### 공지사항 목록(비회원,일반회원(좌) / 관리자(우))
> - No, 제목, 작성자, 작성일 노출
> - 최근 등록 순으로 정렬
> - 10개 단위로 페이징
> - 관리자 권한이 있는 사용자에게만 글쓰기 버튼 노출
> 
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img6.png" width="350px" height="220px">
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img10.png" width="350px" height="220px">

> #### 공지사항 상세(비회원,일반회원(좌) / 관리자(우))
> - 작성자/작성일시/최종수정일시 노출
> - 첨부파일이 있는 경우 다운로드 링크 제공
> - 관리자 권한이 있는 사용자에게만 수정, 삭제 버튼 노출
> 
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img18.png" width="350px" height="220px">
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img11.png" width="350px" height="220px">

> #### 다운로드 링크 클릭 시 다운로드 가능
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img14.png" width="700px">

> #### 공지사항 수정 페이지(관리자)
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img15.png" width="700px">

> #### 공지사항 삭제 요청(관리자)
> - 삭제 완료 후 목록으로 이동
> 
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img16.png" width="700px">

> #### 에러페이지
> <img src="https://github.com/cocodevs/spring-notice-homework/raw/master/images/img12.png" width="700px">

