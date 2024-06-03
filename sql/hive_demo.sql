-- 간단한 데이터 추가 및 조회
use hivedb;

insert into hivedb.my_table values(3, 'kopo', 80.6);

insert into hivedb.my_table values(4, 'hg.dong', 100);

select * from hivedb.my_table;

-- 하둡 분산 파일시스템에 저장된 파일을 로드
create table comedies
(
    line_data String
);

load data inpath '/comedies' overwrite into table comedies;

select * from comedies;

-- 전체 레코드 수 조회
select count(line_data) as cnt from comedies;