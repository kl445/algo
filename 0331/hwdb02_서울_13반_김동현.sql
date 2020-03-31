#1. 상품정보를 저장할 수 있는 테이블을 구성하여 보자.
#(상품코드, 상품명, 상품가격 등

create table product(code int , name varchar(20), price int);

#2. 상품 데이터를 5개 이상 저장하는 SQL을 작성하여 보자.
#( 상품명에 TV, 노트북 포함 하도록 하여 5개 이상)
insert into product
values(1,'TV',10000),
		(2,'노트북',20000),
        (3,'데스크탑',150000),
        (4,'전자레인지',5000),
        (5,'청소기',7000);
        
select * from product; 

#3. 상품을 세일하려고 한다. 15% 인하된 가격의 상품 정보를 출력하세요.
select code, name, price, round(price*0.85) as '15% 할인가'
from product;


#4. TV 관련 상품을 가격을 20% 인하하여 저장하세요. 그 결과를 출력하세요
update product
set price=price*0.8
where name like '%TV%';
select * from product;

#5. 저장된 상품 가격의 총 금액을 출력하는 SQL 문장을 작성하세요
select sum(price) as '총 금액'
from product;
