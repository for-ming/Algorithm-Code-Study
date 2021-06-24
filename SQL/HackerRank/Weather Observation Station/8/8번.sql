SELECT DISTINCT city FROM station
WHERE city REGEXP '[aeiou]$' and city REGEXP '^[aeiou]';


/* 정규표현식 사용 REGEXP */
/*
[ ] : OR의 의미, ^ : 시작 문자, $ : 끝 문자  
'[aeiou]$' ==> a 또는 e 또는 i 또는 o 또는 u로 끝나는 것
'^[aeiou]' ==> a 또는 e 또는 i 또는 o 또는 u로 시작하는 것
*/