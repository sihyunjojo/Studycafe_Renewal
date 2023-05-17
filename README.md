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



# 수정해야할 것들
intercepter 넣을때, requestURL이용해서 checkpw고쳐서 addMemberForm과 editMemberForm에서 비밀번호 확인버튼 동적으로 작동시켜야함.
jpa랑 쿼리 dsl 재대로 
# 환경 
spring boot 2.7.8  
java 11  
gradle  
H2 1.4.2  
