create table MEMBER (
	MEMBERID VARCHAR(10) NOT NULL PRIMARY KEY
    , PASSWORD VARCHAR(10) NOT NULL
    , NAME VARCHAR(20) NOT NULL
    , EMAIL VARCHAR(80)
    ) engine=InnoDB default character set = utf8;

insert into member(memberid, password, name) values('ikjun96', 'whdlrwns96', '조익준');
update member set email='ikjun96@naver.com' where memberid='ikjun96';
insert into member values('miseon95', 'ikjun96722', '김미선', 'miseon95@naver.com');

select * from member;

create table member_history (
	memberid varchar(10) not null primary key
    , history long varchar
)
default character set = utf8;

insert into member_history values('ikjun96', 
	concat(
		'2015 스프링4 프로그래밍입문<br>'
        , '2013 Spring4.0프로그래밍<br>'
        , '2012 객체 지향과 디자인패턴<br>'
        , '2012 JSP 2.2웹프로그래밍\n'
	)
);
select * from member_history;

create table ITEM (
	item_id int not null primary key
    , ame varchar(100)
) engine=InnoDB default character set = utf8mb4;

create table ITEM_DETAIL (
	item_id int not null primary key
    , detail varchar(200)
) engine = InnoDB default character set = utf8mb4;

select * from item;