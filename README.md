# Mentor_Mentee
[멘토멘티] - 스프링 프로젝트

# 학습 노트

## 📌 1. 백엔드와 스프링부트

### ✅ 웹

- HTTP : 클라이언트와 서버가 통신하는 규칙
- Client : 서비스를 요청하는 쪽
- Request : 클라이언트가 서버에게 요청하는 서비스
- Server : 서비스를 제공하는 쪽
- Response : 서버가 클라이언트에게 제공하는 서비스

### ✅ 백엔드

- WebServer : 브라우저의 요청에 따라 정적 콘텐츠(html,css)를 전송하는 소프트웨어이자 하드웨어 (ex nignx, apache 등)
- WebApplicationServer : 웹 서버에서 처리하기 어려운 동적인 데이터를 처리하는 소프트웨어로, 요청에 맞는 api를 호출하고 해당 api에 맞는 로직을 동작시킨다.
- Database : 데이터를 효율적으로 관리하기 위한 체계적 데이터 모음

### ✅ 스프링부트

- 스프링부트 : 톰캣을 내장하고 java언어를 사용하는 웹 프레임워크
    - 라이브러리 : 필요할 때 끌어쓰는 것
    - 프레임워크 : 개발자가 필요한 부분만 개발하고, 실질적 동작 권한을 가진 것
- 스프링부트의 장점
    - 확장성과 유연성
    - 스프링 컨테이너의 객체 관리
    - 내장 서버

---

## 📌 2. MVC 패턴

### ✅ MVC 패턴

: 코드를 역할별로 나누기 위한 디자인 패턴

- M 모델 : 데이터
- V 뷰 : 사용자에게 보여지는 화면
- C 컨트롤러 : 요청을 받아 모델과 뷰 사이 작업 수행

### ✅ 스프링에서 MVC

[ M ]

- DAO(repo) : 데이터 접근 객체 (CRUD 작업)
- DTO : 데이터 변환 객체 목적에 맞는 필수 데이터만 넣어 함수 호출
- DB : 구조화된 정보의 모음

[ V ]

- view : 사용자에게 보여지는 화면

[ C ]

- controller : 사용자 요청받기, 해당 서비스 호출, 응답
- service : 비즈니스 로직

---

## 📌 3. 프로젝트 폴더 구조

### ✅ 계층형 구조

MVC 구조대로 폴더 생성 구조

```java
📁backend (Spring Boot 프로젝트)
|---- 📁Controller  // 컨트롤러 계층(사용자 요청/응답 처리)
|---- 📁Service     // 서비스 계층(비즈니스 로직 담당)
|---- 📁Dto         // 요청/응답 데이터 객체 (클라이언트와 데이터 교환)
|---- 📁Repository  // 데이터 접근 계층 (DB 관련 작업)
|---- 📁Entity      // 데이터 모델 (DB 테이블과 매핑)
```

### ✅ 도메인형 구조

도메인을 중심으로 폴더 생성 구조

```java
📂 backend
 ├── 📂 User
 │    ├── 📂 Controller
 │    ├── 📂 Service
 │    ├── 📂 Repository
 │    ├── 📂 Domain
 │    └── 📂 Dto
 │
 ├── 📂 Webtoon
 │    ├── 📂 Controller
 │    ├── 📂 Service
 │    ├── 📂 Repository
 │    ├── 📂 Domain
 │    └── 📂 Dto
```

- 도메인
    기능을 정의하는 영역
    

---
## 📌 4. 깃과 깃허브

- 깃 : 소스코드를 관리할 수 있도록 하는 로컬 관리 시스템 작업 기록, 버전 관리, 병렬 개발(동시개발)
- 깃허브 : 깃 사용 프로젝트를 지원하는 웹 호스팅 서비스

### ✅ 용어

- CLI / GUI CLI (Command Line Interface) : 명령어 인터페이스 GUI (Graphical User Interface) : 그래픽 인터패이스
    
- Local/Remote
    Local : 내가 사용하는 컴퓨터 Remote : 원격 저장소
- Repository (repo) : 프로젝트 저장소
- Branch : repo 공간에서 독립적인 작업 공간

### ✅ 작업

- Fork : 타인의 repository를 복사해 내 계정으로 가져오기
- Clone : repository를 로컬에 연결하기

```bash
cd “인텔리제이 프로젝트를 모아놓는 폴더 경로”
git clone “깃허브 레포지토리 url”
```

- Commit : 소스코드 업데이트 확정, 로컬 저장소에 반영
    
- Pull/Push
    Pull : 원격저장소에서 로컬저장소로 끌어오는 것 Push : Commit 내용을 원격 저장소에 업로드
    
```bash
git add . # 현재 디렉토리(.) 수정사항 staging에 업로드
git commit -m "입력할 커밋 메시지"
git push origin # (origin: 원격 저장소 이름)
```

Local → online : push
online → Local : pull

조직 레포지토리에 내 깃허브 레포지토리를 넣는 것 : pull request (pr)
base 변경하기

pull request 보내는것
Merge : 잘 되었는지 확인
Merge pull request

나의 레포지토리 안에서 브랜치 나누기
`Main branch`
- `develop branch`
    - 기능1
    - 기능2
    - 기능3

기능 하나를 만들고 develop branch 에 merge 후 기능 브랜치 삭제

---

## 📌 5. 스프링 컨테이너

- 스프링 컨테이너
    - 자바 객체(Bean)의 생명 주기를 관리하는 공간
        - 생명 주기    
            생성, 초기화, 사용, 소멸에 이르는 일련의 과정
            
- 구성
    - 컨테이너 역할을 하는 인터페이스, 이를 구현한 구현체
- 컨테이너의 종류 (핵심 인터페이스)
    
    - BeanFactory: 가장 기본적 기능(빈 생명주기 관리)를 제공하는 최상위 인터페이스
        - appConfig            
            애플리케이션 설정 정보를 담고 있는 자바 클래스, 객체(bean)을 생성하고, 객체(bean)들간의 의존성 주입을 설정하는 역할을 수행
    - ApplicationContext : BeanFactory를 상속받아 더 많은 기능 제공

### ✅싱글톤 패턴
- 클래스의 객체를 한개만 생성하고 그 객체만 돌려 사용하는 패턴

### ✅ 의존성 주입(DI)
- 스프링 컨테이너에서 객체(bean)을 생성하고 생성한 객체를 지정한 객체에 주입하는 방식

### ✅ 어노테이션
: 메타 데이터(부가정보)를 추가하여 스프링 컨테이너에게 객체를 어떻게 처리해야 할지 지시하는 역할

- 어노테이션 모음
    - @Component
        - 클래스를 빈(Bean)으로 등록
    - @RestController
        - RESTful 웹 서비스 컨트롤러에 사용, 메서드의 반환값을 자동으로 JSON 등의 형식으로 변환하여 응답
    - @Configuration
        - 클래스가 빈 설정 정보를 담고 있는 클래스임을 알림
    - @Bean
        - 메서드가 반환하는 객체를 스프링 컨테이너에 빈으로 등록
    - @GetMapping
        - Get 요청을 받는 Controller의 메서드에 사용
    - @Service
        - 비즈니스 로직을 수행하는 Class임을 의미
    - @Entity
        - 실제 DB 테이블과 매핑될 Class임을 의미
    - @RequestBoy
        - 요청이 온 데이터를 바로 class나 model 로 매핑하기 위한 어노테이션
    - @RequiredArgsConstructor
        - final 이나 @NonNull인 필드 값만 파라미터로 받는 생성자 추가
    - @Getter
        - 클래스 내 모든 필드의 Getter 메소드를 자동 생성한다

---

## 📌 URL

- URL : Uniform Resource Locator
    - 브라우저가 웹페이지나 특정 파일을 정확히 찾아가도록 안내해주는 역할

```java
(1)**[https]**://(2)**[comic.naver.com]**:(3)**[443]**(4)**[/webtoon]**
```

(1) **`https`** (Scheme)
⇒ 해당 웹브라우저가 어떤 규칙으로 서버와 대화(통신)할지 정하는 부분

(2) **`comic.naver.com`** (host, 도메인)
⇒ 인터넷에서 사이트의 주소 이름.

(3) **`443`** (Port 번호)
⇒ 서버 컴퓨터에 있는 여러 문들 중, 어떤 문(Port)으로 들어갈지 지정함.

(4) **`/webtoon`** (Path, 경로)
⇒ 서버 안에서 어떤 자원을 요청할지 나타냄.
⇒ 이 부분을 “End Point”라고 함

HTTP 요청
- Post : 데이터 생성
- Get : 데이터 조회
- Put : 데이터 수정
- Delete : 데이터 삭제

---
## 📌 6. 실습해보기 1

: Contoller + Entity 생성

### ✅ 객체 생성

```java
@Entity 
@Getter
@Builder
@ALLArgsConstructor
@NoArgsConstructor
@Table(name= "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	@Builder.Default
	private Long views = OL;
}
```

- 객체(Entity) 어노테이션 모음
    - Entity : 이 클래스를 테이블과 매핑되는 엔티티로 인식하도록 표시
    - Builder : 빌더 패턴을 자동 생성하여 가독성 있게 객체 생성 가능
    - AllArgsConstructor : 모든 필드를 매개변수로 받는 전체 생성자를 자동 생성
    - NoArgsConstructor : 매개변수가 없는 **기본 생성자**를 자동 생성
    - Table : 엔티티가 매핑될 테이블 이름을 지정
    - Id : 엔티티의 기본 키(PK) 필드를 지정
    - GeneratedValue : PK 값을 자동 생성하도록 지정
    - Column : 필드를 테이블의 **컬럼**과 매핑, 컬럼명/길이/nullable 등을 설정 가능
    - Builder.Default : @Builder 사용 시 **필드 기본값**을 유지하도록 지정

### ✅ 컨트롤러 생성

```java
@RestController 
@RequestMapping(@"/api/posts")
public class PostController{

	@PostMapping("/")
	public String createPost(String title, String content) {
	return title + ": " + content + "게시글 생성 완료";
	}
	@GetMapping
	public String getAllPosts() {
	return "게시글 리스트 조회 완료";
	}
	@GetMapping("/{post-id}")
	public String getPostById(@PathVariable(value = "post-id") Long id) {
	return id + "번 게시글 조회 완료";
	}
	@PutMapping("/{post-id}") 
	public String updatePost(@PathVariable(value = "post-id") Long id) {
	return id + "번 게시글 수정 완료";
	}
	@DeleteMapping("/{post-id}") 
	public String deletePost(@PathVariable(value = "post-id") Long id){
	return id + "번 게시글 삭제 완료";
	}
}
```

- 컨트롤러 어노테이션
    - RestController : 해당 클래스가 Web 요청을 담당하는 컨트롤러 기능을 수행하도록 함.
    - RequestMapping : 요청 기본 엔드포인트(url)를 지정,
        - **특정 URL 경로(Path)”로 들어온 요청을 어떤 컨트롤러(혹은 메서드)가 처리할지 연결하는 어노테이션**

@RequestMapping
- “특정 URL 경로(Path)”로 들어온 요청을 어떤 컨트롤러(혹은 메서드)가 처리할지 연결하는 어노테이션

@PostMapping()/GetMapping()…
- 각 Controller들은 클라이언트가 보낸 Post, Get, Put, Delete 요청들을 받고 응답을 보내는 역할

→ 수행 기능이 다르지만 동일한 엔드포인트를 가진 API

### ✅ DB 연동 - mySQL

1. 깃허브에 올리면 안되는 중요한 값 처리
    1. 설정 파일 [application.properties](http://application.properties) 삭제
    2. .gitignore에 [application.properties](http://application.properties) 추가
    3. src/main/resources 경로에 [application.properties](http://application.properties) 생성
    
2. MySQL 접속해 DB 만들기
```bash
# 현재 MySQL에 존재하는 데이터베이스 목록 확인
show database;

# mmdb 라는 데이터베이스 생성
create database mmdb;

# 현재 MySQL에 존재하는 데이터베이스 목록 확인
show database;
```

```bash
# 해당 DB로 접속
use mmdb;

# 해당 DB속 테이블 목록 확인
show tables;

# post 테이블의 정보 확인
desc post;
```

### ✅ SecurityConfig 작성

```java
@Configuration
public class SecurityConfig {

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	http.authorizeHttpRequests(
		 request ->
		request
			// /api 경로로 들머오는 모든 요청은 허락
			.requestMatchers(O"/api/ ** ") 
			.permitAll() 
			// 그 외 모든 요청은 인증 필요
			.anyRequest()
			.authenticated()
		}
		.csrf(AbstractHttpConfigurer: :disable);
		return http.build();
	}
}
```

의존성을 추가할 때 spring security 의존성을 build.gradle에 추가했는데,
해당 의존성은 스프링부트로 오는 여러 요청들에 대한 보안 관련 역할을 한다.
따라서 이를 위한 설정 파일을 또 하나 만들어 줘야 한다.

→ global 하위에 config 패키지를 만들고, SecurityConfig 를 클래스로 만들기

### ▶️ 코드 확인 : GET 요청 보내보기

1. 웹브라우저를 실행 시킨 후 [http://localhost:8080](http://localhost:8080) 입력 (스프링부트 동작시킨 후)
2. 액세스 거부되면 정상 ( /api 경로가 아닌 모든 요청은 인증이 필요하도록 했기 때문)
3. [http://localhost:8080/api/posts](http://localhost:8080/api/posts) 입력 (게시글 리스트 조회)
4. [http://localhost:8080/api/posts/1](http://localhost:8080/api/posts/1) 입력 (1번 게시글 조회)

- 로그인 창 뜨면 user, terminal에 뜨는 비밀번호

---
## 📌 7. 실습해보기 2
: DTO

### ✅ DTO 생성

- 기존 방식
    ```java
    public class PostRequestDto{
        private final String title;
        private final String content;
        public PostRequestDto(String title, String content){
    		    this.title = title;
    		    this.content = content;
        }
    }
    
    PostRequestDto dto = new PostRequestDto("첫 글", "내용");
    ```
    
- Builder 방식
    ```java
    @Builder
    public class PostRequestDto{
        private final String title;
        private final String content;
    }
    
    PostRequestDto dto = PostRequestDto.builder()
                 .title("첫 글")
                 .content("내용")
                 .build();
    ```
    
- **Dto 내부 변수를 private, final를 붙여서 선언해주는 이유**
    Dto 내부에 있는 데이터를 외부에서 보이지 않게 하고, 외부에서 Dto 내부에 있는 데이터를 변경할 수 없게 하도록 하기 위함
    
- DTO 생성
```java
import lombok.*;

@Getter
@Builder
public class PostRequestDto {
    private final String title;
    private final String content;
}
```

@Getter / @Setter : 해당 클래스의 필드 변수에 한 Getter, Setter 함수들을 자동으로 생성

- **DTO에 @Setter를 붙이면 안되는 이유**
    애초에 필드변수에 final을 붙여서 @Setter를 붙여서 setter 함수가 생성되지는 않으나, 혹시나 개발자의 실수로 setter함수가 DTO에 생긴다면
    **”DTO 내부의 값을 변경시킬 수 있게 된다.”**
    이렇게 되면 값이 이동하는 중간에 데이터의 값이 바뀌어 예상치 못한 버그가 발생할 수 있다.
    
- Controller 수정
```java
import com.example.mentor_mentee.domain.post.dto.request.PostRequestDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @PostMapping
    public String createPost(PostRequestDto postRequestDto) {
        return postRequestDto.getTitle() + ": " + postRequestDto.getContent() + "게시글 생성 완료";
    }
...
}
```

- @Builder
- @Getter/@SetterSe
- @RequestBody
