create table r_board(
	r_no number(3) primary key, 
	r_writer varchar2(20 char) not null,
	r_photo varchar2(150 char),
	r_txt varchar2(500 char) not null,
	r_date date not null,
	r_star varchar2(2 char) not null
);

drop table r_board cascade constraint purge; 

create sequence r_board_seq;
drop sequence r_board_seq;

select * from r_board;

----------------------------------------------------

create table p_customer(
c_id varchar2(20char) primary key,
c_pw varchar2(20char) not null,
c_name varchar2(20char) not null,
c_phone varchar2(20char)not null,
c_address varchar2(150char)not null --DAO에서 세개 합쳐서 담음
);

drop table p_customer cascade constraint purge;

insert into p_customer values('a','a','a','010-1232-1212','서울특별시')


select * from P_CUSTOMER;
delete  from  P_CUSTOMER where c_id='abcde'
drop table p_customer cascade constraint purge;
------------------------------------------------------------------------
-- 아이디 중복확인
select c_id,c_pw,c_name,c_phone,c_address from p_customer where c_id=#{c_id}
------------------------------------------------------------------------
아이디-pk
e

비번
회사명 
회사주소
create table p_company(
com_id varchar2(20char) primary  key,
com_pw varchar2(20char) not null,
com_phone varchar2(20char) not null,
com_name varchar2(30 char) not null,
com_address varchar2(150 char)not null,
com_category varchar2(150char) not null
);

drop table p_company cascade constraint purge;

insert into p_company values('c','c','c','dd','a','b');

select * from p_company;
---------------------------------------------------------------
1. 날짜&시간-0
2. 주소-0
3. 예약번호-pk-0 - mapper에서 자동매기기
4. 회원이름-0
5. 전화번호-0
6. 몇평

create table p_reserve(
r_num number(5) primary key,
r_date date not null,
r_id varchar2(20char) not null,
r_name varchar2(100char) not null,
r_phone varchar2(100char) not null,
r_address varchar2(200char) not null,
r_area varchar2(100char) not null
);

drop table p_reserve cascade constraint purge;

create sequence r_num_seq;
drop sequence r_num_seq;

select*from p_reserve;

-- 예약하기
-- 고객테이블이랑 예약테이블조인..?
select c.sequence r_num_seq,
from p_customer c,p_reserve r

insert into p_reserve values(r_num_seq.nextval,sysdate,'kkr','김경래','010-1234-4567','주소','55');
insert into p_reserve values(r_num_seq.nextval,sysdate,'kkr','김경래','010-1234-4567','주소','77');

-- 회원 조회
select *from p_reserve where r_id='kkr' order by r_num desc;






