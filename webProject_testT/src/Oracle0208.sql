
/* Drop Tables */

DROP TABLE board0208 CASCADE CONSTRAINTS;
DROP TABLE Member0208 CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE board0208
(
	No number NOT NULL ,
	title varchar2(255 char) NOT NULL,
	content varchar2(100 char) NOT NULL,
	userId varchar2(100 char) NOT NULL,
	PRIMARY KEY (No)
);

drop sequence board0208_SEQ;

create sequence board0208_SEQ
increment by 1
start with 1
nocycle
nocache
;



CREATE TABLE Member0208
(
	no number NOT NULL ,
	userId varchar2(255 char) NOT NULL UNIQUE,
	userPW varchar2(100) NOT NULL,
	name varchar2(100) NOT NULL,
	PRIMARY KEY (no)
);

drop sequence member0208_SEQ;

create sequence member0208_SEQ
increment by 1
start with 1
nocycle
nocache
;


select* from user_sequences;

/* Create Foreign Keys */

ALTER TABLE board0208
    ADD CONSTRAINT board0208_FK -- 선택(제약조건명)
	FOREIGN KEY (userId)
	REFERENCES member0208 (userId)
;

alter table board0208 drop constraint board0208_FK;

-- member0208 5개 데이터(회원)
insert into member0208(no,userId,userPw,name) values(member0208_seq.nextval,'m1','11','s1');
insert into member0208(no,userId,userPw,name) values(member0208_seq.nextval,'m2','22','s2');
insert into member0208(no,userId,userPw,name) values(member0208_seq.nextval,'m3','33','s3');
insert into member0208(no,userId,userPw,name) values(member0208_seq.nextval,'m4','44','s4');
insert into member0208(no,userId,userPw,name) values(member0208_seq.nextval,'m5','55','s5');

rollback;
commit;

delete from member0208;
select* from member0208;

select* from board0208;
select* from board0208 where userId='m1';


-- inner join 두 테이블 조회
select* 
from member0208 m inner join board0208 b
on m.userid=b.userid
;

select*
from member0208 m inner join board0208 b
on m.userid=b.userid
group by b.userid
having b.userid='m1'
;

desc board0208;

insert into board0208(no,title,content,userId) values (board0208_SEQ.nextval,'제목1','내용1','m1');


