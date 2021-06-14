--ex17_delete.sql


/*
delete문
- DML
- 데이터를 삭제하는 명령어(레코드, 행)
- delete [from] 테이블명 [where절]
*/

commit;
rollback;

select * from tblCountry;

delete from tblCountry;
delete from tblCountry where continent = 'AS';
delete from tblCountry where name = '대한민국';
