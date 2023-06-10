# Studycafe_Renewal

2년동안 공부하면서 기존에 studycafe 프로젝트의 심각성을 깨닫고 renewal해보려한다.     

## 5/2
form에서 객체가 넘어오질 않는다. 타임리프 submit공부 필요.  

## 5/12
기초 기술들을 익혔지만 프로젝트의 흐름을 따라가면서 어떻게 작동하는지에 대한 이해가 많이 부족한 것을 느꼈다.   
앞으로 프로젝트를하면서 배운 기술을들 기술이 작동되는 전체적인 흐름을 잘 파악해서 오류나 하고 싶은 기능을 원활하게 할 수 있게     
하나의 기술을 사용하더라도 더 넓은 그림을 보고 기술이 어떻게 작용하는지 자세히 알아야겠다.  

## 5/13
Repository형태 고민...
jpa와 쿼리dsl을 재대로 편하게 쓰기위해서 프로젝트 구조를 바꿔야하는데 어떻게 해야할지 고민..  
+ 현재 jpaRepsoitory가 너무 형편없고 구지다...  
+ 프로젝트 다시 한번 보면서 재대로 코드 작성하자  

## 5/17
intercept와 exception은 나중에 작업하기로 결정.  

기존 코드는 공지사항과 커뮤니티를 따로 구분되어 있지만, 이번에는 하나 table로 관리하기로 결정.  
기존 작성일자인 board.time을 **날짜와 시간을 정확하게 저장하기 위해서** varchar가 아닌 timestamp로 사용하기로 결정.  

## 5/20
username을 검색기능에 추가하기 위해서 username을 db에 넣었다. 
이게 맞는 결과일까??

그러니 username을 사용하기 위한 boardForm이 현재 애매해졌다

그치만 추후에 10개나 20개 마다 아래 버튼을 만들어서 페이지를 넘어가게 해줄때 쓸 수 있을거 같다.

## 5/22
상품쪽 기본 뼈대 만들기

# 5/23
검색기능에 가격이랑 좋아요수 마저하기

home best 상품에도 상품 카테고리 검색은 만들기 

## 5/24
장바구니 기능을 구현하는데, 장바구니와 장바구니 상품을 담는 2가지 테이블이 필요할거 같았다.

처음에는 2개의 테이블을 하나로 구현하려고 했지만,
두개의 테이블은 엄연히 역할이 너무 다르므로 역할을 재대로 구분하지 못하여서 좋지 않은 코드가 될거 같다는 생각이 들어서 하던걸 갈아 엎고, 다시 작성하였다.

3가지 장점이 있따. 
- 확장성

장바구니에 여러 개의 상품을 담을 수 있고, 상품의 수량, 가격 등을 개별적으로 관리할 수 있습니다. 이는 장바구니 기능을 더욱 유연하게 확장할 수 있게 해줍니다
- 일관성 

-장바구니 정보를 수정할 때 장바구니 테이블과 장바구니 상품 테이블을 동시에 업데이트할 수 있습니다.
- 성능

장바구니에 대한 쿼리와 장바구니 상품에 대한 쿼리를 별도로 실행할 수 있으며, 성능을 최적화할 수 있습니다.

+ 장바구니에 중복으로 들어가는거 해결
## 5/25
장바구니에서 빼기

## 5/26
공지사항은 게시판 맨위로
게시판 권한에 따라서 특정 종류 게시판 쓰기,수정 접근 안되게하기
- 안 됬던 이유가 권한이 없던 페이지의 경로에서 redirectURI로 보냈을때, redirectURI가 요청 메서드에 도착을 못해서 defaultValue만 값이 지정되었다  
이유가 뭐였냐면 타임리프에서 form태그에서 th:action을 th:action="login"으로 수동 설정해서 그런거였다. th:action 만하여서 경로를 그대로 post로 보내줬어야했다.  
그래야지 뒤에 RequestParam까지 경로로 들어간다.

**인터셉터 활용시 주의 사항**  
클라이언트 부분에서 서버를 통하지 않고 바로 클라이언트나 서버사이드를 통해서 경로를 보낼경우 인터셉터가 작동하지 않는다.  
어떻게 보면 당연하다. dispatcherServlet에 도달하지 않으니 인터셉트가 작동할 수 없다.
ex)  
button th:onclick="|location.href='@{board/add}'|" type="button" ></button  
는 @{board/add}로 사용하여 서버사이드를 통해서 경로가 전달된다.그래서  
button th:onclick="|location.href='/board/add'|"></button

얘는 되는 이유가 뭐야?

## 5/27
인터셉터 기능 사용 완료

## 5/31
게시판 댓글, 답글 (DB고쳐야함)

## 6/1
게시판,상품(boards,products)에서 좋아요순,조회순,이런거 만들어주기

## 6/2 
팝업
formatter로 datetime바꾸기

## 6/3  
이상한 부분 전부 바꾸기 완료
페이지 넘버 붙이기 (1)

## 6/5
공지사항은 아예 완전 별도로 해서 맨 마지막에 붙이기
페이지 넘버 붙이기 (2)

## 6/7
상품에도 넘버 붙이기
게시판 10개나 20개 마다 아래 버튼을 만들어서 페이지를 넘어가게 해줄때 쓰기

## 6/8
소스트리 활용
develop 브랜치 생성 + 분리의 필요성 느낌.

## 6/9
OAuth2.0 (1)

## 6.10 
mysql
+ DB바꾸고 처음부터하니 몇몇 오류 수정
  OAuth2.0 (2)

### 수정해야할 것들
OAuth2.0

게시판 추천 수 (ajax)
상품 좋아요 버튼 만들기(ajax, api,json) (이건 추후에 orderproduct를 만들어서 하는게 맞는거 같은데)        // 이걸하려면 멤버마다 그 보드에 대한 like를 유지하고 있는지에 대한 db 컬럼이 필요하다.

home에 좋아요 많은 순서대로 상품 보여주기
home에 게시판도 공지사항 맨위로 하고 밑에는 인기 게시판으로 할까??

상품검색에서 최대 가격이 최소가격보다 작으면 오류 만들어주기.  

장바구니에 상품 추가할때, 상품 개수 클라이언트에서 가져와서 그만큼 추가해줘야함(html도 수정해야하고 service도 수정해야함): 이건 추후에 소비자를 위한 order을 만들어야할지도..?
(사장,소비자 구분)사장님만 등록 할 수 있게 page만들기 추후에
(권한관리는 enum 활용해서 )

#### 할까말까 고민...

# 환경 
spring boot 2.7.8    
java 11    
gradle  
H2 1.4.2  
