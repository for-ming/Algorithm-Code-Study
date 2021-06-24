// 아픈 동물 찾기

SELECT animal_id, name FROM animal_ins WHERE intake_condition LIKE 'Sick' ORDER BY animal_id;

// 어린 동물 찾기

SELECT animal_id, name FROM animal_ins WHERE intake_condition NOT LIKE 'Aged' ORDER BY animal_id;

// 동물의 아이디와 이름

SELECT animal_id, name FROM animal_ins ORDER BY animal_id;

// 여러 기준으로 정렬하기

SELECT animal_id, name, datetime FROM animal_ins ORDER BY name, datetime desc;

// 상위 n개 레코드

SELECT name FROM animal_ins ORDER BY datetime LIMIT 1;
SELECT * FROM (SELECT name FROM animal_ins ORDER BY datetime) WHERE rownum <= 1 ;

// 최댓값 구하기

SELECT datetime as 시간 FROM (SELECT * FROM animal_ins ORDER BY datetime DESC) WHERE rownum <= 1;

// 최솟값 구하기

SELECT datetime as 시간 FROM (SELECT * FROM animal_ins ORDER BY datetime) WHERE rownum <= 1;

// 동물 수 구하기

SELECT count(*) as count FROM animal_ins;

// 중복 제거하기

SELECT count(*) FROM (SELECT DISTINCT name FROM animal_ins WHERE name IS NOT NULL);

// 고양이와 개는 몇 마리 있을까

SELECT animal_type, count(*) AS count FROM animal_ins WHERE animal_type LIKE 'Cat' OR animal_type LIKE 'Dog' GROUP BY animal_type ORDER BY animal_type;

// 동명 동물 수 찾기

SELECT name, count(name) AS count FROM animal_ins WHERE name IS NOT NULL GROUP BY name HAVING count(name) >= 2 ORDER BY name;

// 입양 시각 구하기(1)

SELECT TO_CHAR(datetime, 'HH24') AS hour, COUNT(TO_CHAR(datetime, 'HH24')) AS count FROM animal_outs WHERE TO_CHAR(datetime, 'HH24') BETWEEN 9 AND 19 GROUP BY TO_CHAR(datetime, 'HH24') ORDER BY TO_CHAR(datetime, 'HH24');

// 입양 시각 구하기(2)

SELECT HOUR, COUNT(TO_CHAR(a.datetime, 'HH24')) AS COUNT FROM (SELECT LEVEL-1 AS HOUR FROM DUAL CONNECT BY LEVEL <= 24) h LEFT JOIN animal_outs a ON h.hour = TO_CHAR(a.datetime, 'HH24') GROUP BY h.hour ORDER BY h.hour;

// 이름이 없는 동물의 아이디

SELECT animal_id FROM animal_ins WHERE name IS NULL ORDER BY animal_id;

// 이름이 있는 동물의 아이디

SELECT animal_id FROM animal_ins WHERE name IS NOT NULL ORDER BY animal_id;

// NULL 처리하기

SELECT animal_type, CASE WHEN name IS NULL THEN 'No name' ELSE name END, SEX_UPON_INTAKE FROM animal_ins ORDER BY animal_id;

// 없어진 기록 찾기

SELECT o.animal_id, o.name FROM animal_ins i RIGHT JOIN animal_outs o ON i.animal_id = o.animal_id WHERE i.animal_id IS NULL ORDER BY o.animal_id;

// 있었는데요 없었습니다

SELECT o.animal_id, o.name FROM animal_ins i JOIN animal_outs o ON i.animal_id = o.animal_id WHERE i.datetime > o.datetime ORDER BY i.datetime;

// 오랜 기간 보호한 동물(1)

SELECT * FROM (SELECT i.name, i.datetime FROM animal_ins i LEFT JOIN animal_outs o ON i.animal_id = o.animal_id WHERE o.animal_id IS NULL ORDER BY i.datetime) WHERE rownum < 4;

// 보호소에서 중성화한 동물

SELECT i.animal_id, i.animal_type, i.name FROM animal_ins i JOIN animal_outs o ON i.animal_id = o.animal_id WHERE i.SEX_UPON_INTAKE NOT LIKE o.SEX_UPON_OUTCOME ORDER BY i.animal_id;

// 루시와 엘라 찾기

SELECT animal_id, name, SEX_UPON_INTAKE FROM animal_ins WHERE name LIKE 'Lucy' OR name LIKE 'Ella' OR name LIKE 'Pickle' OR name LIKE 'Rogan' OR name LIKE 'Sabrina' OR name LIKE 'Mitty' ORDER BY animal_id;

// 이름에 el이 들어가는 동물 찾기

SELECT animal_id, name FROM animal_ins WHERE (name LIKE '%EL%' OR name LIKE '%El%' OR name LIKE '%eL%' OR name LIKE '%el%') AND animal_type LIKE 'Dog' ORDER BY name;

// 중성화 여부 파악하기

SELECT animal_id, name, CASE WHEN SEX_UPON_INTAKE LIKE 'Neutered Male' THEN 'O' WHEN SEX_UPON_INTAKE LIKE 'Spayed Female' THEN 'O' ELSE 'X' END FROM animal_ins ORDER BY animal_id;

// 오랜 기간 보호한 동물(2)

SELECT * FROM (SELECT i.animal_id, i.name FROM animal_ins i JOIN animal_outs o ON i.animal_id = o.animal_id ORDER BY (o.datetime - i.datetime) DESC) WHERE ROWNUM < 3;

// DATETIME에서 DATE로 형 변환

SELECT animal_id, name, TO_CHAR(datetime, 'YYYY-mm-DD') AS 날짜 FROM animal_ins ORDER BY animal_id;

// 모든 레코드 조회하기

SELECT * FROM animal_ins ORDER BY animal_id;

// 역순 정렬하기

SELECT name, datetime FROM animal_ins ORDER BY animal_id desc;

// 우유와 요거트가 담긴 장바구니

SELECT DISTINCT cart_id FROM cart_products WHERE cart_id IN (SELECT DISTINCT cart_id FROM cart_products WHERE name LIKE 'Milk') AND name LIKE 'Yogurt' ORDER BY cart_id;

// 헤비 유저가 소유한 장소

SELECT id, name, host_id FROM places WHERE host_id IN (SELECT DISTINCT host_id FROM places GROUP BY host_id HAVING count(*) >= 2) ORDER BY id;

