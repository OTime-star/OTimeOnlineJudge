drop table oj_problemSolveState;
drop table oj_judgeRecord;
drop table oj_submitRecord;
drop table oj_sampleJudgeData;
drop table oj_actualJudgeData;
drop table oj_problem;
drop table oj_user;


create table oj_user(
	id number,
	nickname varchar(20),
	email varchar(40),
	password varchar(20),
	primary key(id),
	unique(email),
	unique(nickname)
);

create table oj_problem(
	id number,
	title varchar(40) not null,                
	description clob,
	inputformat clob,
	outputformat clob,
	timeLimit number,
	memoryLimit number,
	totalSubmissions number,
	acceptSubmissions number,
	primary key(id)	
);

create table oj_sampleJudgeData(
	id number,
	problem_id number,
	inputData clob,
	resultData clob,
	primary key(id),
	foreign key(problem_id) references oj_problem(id)
);


create table oj_actualJudgeData(
	id number,
	problem_id number,
	inputData clob,
	resultData clob,
	primary key(id),
	foreign key(problem_id) references oj_problem(id)
);

create table oj_submitRecord(
	id number,
	user_id number,
	problem_id number,
	contentType varchar(40),
	content clob,
	executionTime number,
	memoryCost number,
	score number,
	result varchar(40),
	submitDate date,
	primary key(id),
	foreign key(user_id) references oj_user(id),
	foreign key(problem_id) references oj_problem(id)
);

create table oj_judgeRecord(
	id number,
	submitRecord_id number,
	executionTime number,
	memoryCost number,
	result varchar(40),
	primary key(id),
	foreign key(submitRecord_id) references oj_submitRecord(id)
);

create table oj_problemSolveState(
	user_id number,
	problem_id number,
	submitRecord_id number,
	state varchar(20),
	stateDate date,
	primary key(user_id, problem_id),
	foreign key(user_id) references oj_user(id),
	foreign key(problem_id) references oj_problem(id),
	foreign key(submitRecord_id) references oj_submitRecord(id)
);

drop sequence seq_oj_user;
drop sequence seq_oj_problem;
drop sequence seq_oj_sampleJudgeData;
drop sequence seq_oj_actualjudgeData;
drop sequence seq_oj_submitRecord;
drop sequence seq_oj_judgeRecord;

create sequence seq_oj_user;
create sequence seq_oj_problem;
create sequence seq_oj_sampleJudgeData;
create sequence seq_oj_actualjudgeData;
create sequence seq_oj_submitRecord;
create sequence seq_oj_judgeRecord;

-- oj_user
select seq_oj_user.nextval from dual;
insert into 
oj_user(id,email,nickname,password) 
values(1, '17361563928@163.com', 'user165848616', 123456);

select seq_oj_user.nextval from dual;
insert into 
oj_user(id,email,nickname,password) 
values(2, '17361563928@qq.com', 'user965888616', 123);

-- oj_problem
select seq_oj_problem.nextval from dual;
insert into
oj_problem(id,title,description,inputformat,outputformat,
	timeLimit, memoryLimit, totalSubmissions,acceptSubmissions)
values(1, 'A+B',
	'Calculate a+b',
	'Two integer a,b (0<=a,b<=1000000000)',
	'Output a+b',
	1000, 256 * 1024, 0, 0
);

select seq_oj_problem.nextval from dual;
insert into
oj_problem(id,title,description,inputformat,outputformat,
	timeLimit,memoryLimit,totalSubmissions,acceptSubmissions)
values(2, 'A-B',
	'Calculate a-b',
	'Two integer a,b (0<=a,b<=1000000000)',
	'Output a-b',
	1000, 256 * 1024, 0, 0
);

-- oj_sampleJudgeData
select seq_oj_sampleJudgeData.nextval from dual;
insert into
oj_sampleJudgeData(id,problem_id,inputData,resultData)
values(1, 1, '1 1', '2');

select seq_oj_sampleJudgeData.nextval from dual;
insert into
oj_sampleJudgeData(id,problem_id,inputData,resultData)
values(2, 1, '5 4', '9');

select seq_oj_sampleJudgeData.nextval from dual;
insert into
oj_sampleJudgeData(id,problem_id,inputData,resultData)
values(3, 2, '2 1', '1');

select seq_oj_sampleJudgeData.nextval from dual;
insert into
oj_sampleJudgeData(id,problem_id,inputData,resultData)
values(4, 2, '18 8', '10');


-- oj_actualJudgeData
select seq_oj_actualJudgeData.nextval from dual;
insert into 
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(1, 1, '1 1', '2');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(2, 1, '1 3', '4');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(3, 1, '2 8', '10');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(4, 1, '100 276', '376');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(5, 1, '10001 20002', '30003');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(6, 1, '111111111 555555555', '666666666');

select seq_oj_actualJudgeData.nextval from dual;
insert into 
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(7, 2, '2 1', '1');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(8, 2, '10 8', '2');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(9, 2, '666 222', '444');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(10, 2, '100 276', '-176');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(11, 2, '30003 20002', '10001');

select seq_oj_actualJudgeData.nextval from dual;
insert into
oj_actualJudgeData(id,problem_id,inputData,resultData)
values(12, 2, '555555555 111111111', '444444444');

-- oj_submitRecord
select seq_oj_submitRecord.nextval from dual;
insert into
oj_submitRecord(
	id,
	user_id,
	problem_id,
	contentType,
	content,
	executionTime,
	memoryCost,
	score,
	result,
	submitDate
) values (
	1,
	1,
	1,
	'java',
	'import java.io.*;\r\nimport java.util.*;\r\npublic class Main{\r\npublic static void main(String[] args) {\r\nScanner sc = new Scanner(System.in);\r\nint a = sc.nextInt();\r\nint b = sc.nextInt();\r\nint c = a + b;\r\nSystem.out.println(c);\r\nsc.close();\r\n}\r\n}\r\n',
	31,
    102,
    100,
    'AC',
    sysdate
);

-- oj_judgeRecord
select seq_oj_judgeRecord.nextval from dual;
insert into
oj_judgeRecord(id,submitRecord_id,executionTime,memoryCost,result)
values(1, 1, 1, 2, 'AC');

select seq_oj_judgeRecord.nextval from dual;
insert into
oj_judgeRecord(id,submitRecord_id,executionTime,memoryCost,result)
values(2, 1, 1, 2, 'AC');

select seq_oj_judgeRecord.nextval from dual;
insert into
oj_judgeRecord(id,submitRecord_id,executionTime,memoryCost,result)
values(3, 1, 2, 4, 'AC');

select seq_oj_judgeRecord.nextval from dual;
insert into
oj_judgeRecord(id,submitRecord_id,executionTime,memoryCost,result)
values(4, 1, 2, 4, 'AC');

select seq_oj_judgeRecord.nextval from dual;
insert into
oj_judgeRecord(id,submitRecord_id,executionTime,memoryCost,result)
values(5, 1, 5, 12, 'AC');

select seq_oj_judgeRecord.nextval from dual;
insert into
oj_judgeRecord(id,submitRecord_id,executionTime,memoryCost,result)
values(6, 1, 16, 80, 'AC');

INSERT INTO 
OJ_PROBLEMSOLVESTATE(user_id, problem_id, submitRecord_id, state, stateDate)
VALUES(1, 1, 1, 'Accept', sysdate);

commit;

select seq_oj_user.currVal from dual;
select seq_oj_problem.currVal from dual;
select seq_oj_sampleJudgeData.currVal from dual;
select seq_oj_actualjudgeData.currVal from dual;
select seq_oj_submitRecord.currVal from dual;
select seq_oj_judgeRecord.currVal from dual;

