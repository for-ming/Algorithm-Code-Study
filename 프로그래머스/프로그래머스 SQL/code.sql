// ���� ���� ã��

SELECT animal_id, name FROM animal_ins WHERE intake_condition LIKE 'Sick' ORDER BY animal_id;

// � ���� ã��

SELECT animal_id, name FROM animal_ins WHERE intake_condition NOT LIKE 'Aged' ORDER BY animal_id;

// ������ ���̵�� �̸�

SELECT animal_id, name FROM animal_ins ORDER BY animal_id;

// ���� �������� �����ϱ�

SELECT animal_id, name, datetime FROM animal_ins ORDER BY name, datetime desc;

// ���� n�� ���ڵ�

SELECT name FROM animal_ins ORDER BY datetime LIMIT 1;
SELECT * FROM (SELECT name FROM animal_ins ORDER BY datetime) WHERE rownum <= 1 ;

// �ִ� ���ϱ�

SELECT datetime as �ð� FROM (SELECT * FROM animal_ins ORDER BY datetime DESC) WHERE rownum <= 1;

// �ּڰ� ���ϱ�

SELECT datetime as �ð� FROM (SELECT * FROM animal_ins ORDER BY datetime) WHERE rownum <= 1;

// ���� �� ���ϱ�

SELECT count(*) as count FROM animal_ins;

// �ߺ� �����ϱ�

SELECT count(*) FROM (SELECT DISTINCT name FROM animal_ins WHERE name IS NOT NULL);

// ����̿� ���� �� ���� ������

SELECT animal_type, count(*) AS count FROM animal_ins WHERE animal_type LIKE 'Cat' OR animal_type LIKE 'Dog' GROUP BY animal_type ORDER BY animal_type;

// ���� ���� �� ã��

SELECT name, count(name) AS count FROM animal_ins WHERE name IS NOT NULL GROUP BY name HAVING count(name) >= 2 ORDER BY name;

// �Ծ� �ð� ���ϱ�(1)

SELECT TO_CHAR(datetime, 'HH24') AS hour, COUNT(TO_CHAR(datetime, 'HH24')) AS count FROM animal_outs WHERE TO_CHAR(datetime, 'HH24') BETWEEN 9 AND 19 GROUP BY TO_CHAR(datetime, 'HH24') ORDER BY TO_CHAR(datetime, 'HH24');

// �Ծ� �ð� ���ϱ�(2)

SELECT HOUR, COUNT(TO_CHAR(a.datetime, 'HH24')) AS COUNT FROM (SELECT LEVEL-1 AS HOUR FROM DUAL CONNECT BY LEVEL <= 24) h LEFT JOIN animal_outs a ON h.hour = TO_CHAR(a.datetime, 'HH24') GROUP BY h.hour ORDER BY h.hour;

// �̸��� ���� ������ ���̵�

SELECT animal_id FROM animal_ins WHERE name IS NULL ORDER BY animal_id;

// �̸��� �ִ� ������ ���̵�

SELECT animal_id FROM animal_ins WHERE name IS NOT NULL ORDER BY animal_id;

// NULL ó���ϱ�

SELECT animal_type, CASE WHEN name IS NULL THEN 'No name' ELSE name END, SEX_UPON_INTAKE FROM animal_ins ORDER BY animal_id;

// ������ ��� ã��

SELECT o.animal_id, o.name FROM animal_ins i RIGHT JOIN animal_outs o ON i.animal_id = o.animal_id WHERE i.animal_id IS NULL ORDER BY o.animal_id;

// �־��µ��� �������ϴ�

SELECT o.animal_id, o.name FROM animal_ins i JOIN animal_outs o ON i.animal_id = o.animal_id WHERE i.datetime > o.datetime ORDER BY i.datetime;

// ���� �Ⱓ ��ȣ�� ����(1)

SELECT * FROM (SELECT i.name, i.datetime FROM animal_ins i LEFT JOIN animal_outs o ON i.animal_id = o.animal_id WHERE o.animal_id IS NULL ORDER BY i.datetime) WHERE rownum < 4;

// ��ȣ�ҿ��� �߼�ȭ�� ����

SELECT i.animal_id, i.animal_type, i.name FROM animal_ins i JOIN animal_outs o ON i.animal_id = o.animal_id WHERE i.SEX_UPON_INTAKE NOT LIKE o.SEX_UPON_OUTCOME ORDER BY i.animal_id;

// ��ÿ� ���� ã��

SELECT animal_id, name, SEX_UPON_INTAKE FROM animal_ins WHERE name LIKE 'Lucy' OR name LIKE 'Ella' OR name LIKE 'Pickle' OR name LIKE 'Rogan' OR name LIKE 'Sabrina' OR name LIKE 'Mitty' ORDER BY animal_id;

// �̸��� el�� ���� ���� ã��

SELECT animal_id, name FROM animal_ins WHERE (name LIKE '%EL%' OR name LIKE '%El%' OR name LIKE '%eL%' OR name LIKE '%el%') AND animal_type LIKE 'Dog' ORDER BY name;

// �߼�ȭ ���� �ľ��ϱ�

SELECT animal_id, name, CASE WHEN SEX_UPON_INTAKE LIKE 'Neutered Male' THEN 'O' WHEN SEX_UPON_INTAKE LIKE 'Spayed Female' THEN 'O' ELSE 'X' END FROM animal_ins ORDER BY animal_id;

// ���� �Ⱓ ��ȣ�� ����(2)

SELECT * FROM (SELECT i.animal_id, i.name FROM animal_ins i JOIN animal_outs o ON i.animal_id = o.animal_id ORDER BY (o.datetime - i.datetime) DESC) WHERE ROWNUM < 3;

// DATETIME���� DATE�� �� ��ȯ

SELECT animal_id, name, TO_CHAR(datetime, 'YYYY-mm-DD') AS ��¥ FROM animal_ins ORDER BY animal_id;

// ��� ���ڵ� ��ȸ�ϱ�

SELECT * FROM animal_ins ORDER BY animal_id;

// ���� �����ϱ�

SELECT name, datetime FROM animal_ins ORDER BY animal_id desc;

// ������ ���Ʈ�� ��� ��ٱ���

SELECT DISTINCT cart_id FROM cart_products WHERE cart_id IN (SELECT DISTINCT cart_id FROM cart_products WHERE name LIKE 'Milk') AND name LIKE 'Yogurt' ORDER BY cart_id;

// ��� ������ ������ ���

SELECT id, name, host_id FROM places WHERE host_id IN (SELECT DISTINCT host_id FROM places GROUP BY host_id HAVING count(*) >= 2) ORDER BY id;

