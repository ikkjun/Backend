create table MEMBER (
	MEMBERID VARCHAR(10) NOT NULL PRIMARY KEY
    , PASSWORD VARCHAR(10) NOT NULL
    , NAME VARCHAR(20) NOT NULL
    , EMAIL VARCHAR(80)
    ) engine=InnoDB default character set = utf8;

insert into member(memberid, password, name) values('ikjun96', 'whdlrwns96', '조익준');
update member set email='ikjun96@naver.com' where memberid='ikjun96';
insert into member values('miseon95', 'ikjun960722', '김미선', 'miseon95@naver.com');
select * from member;