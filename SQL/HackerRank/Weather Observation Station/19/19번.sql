/* 
반올림 Round ( , -번째 자리)
최대 Max( )
최소 Min( )
제곱 Pow( , -번 제곱)
제곱근 Sqrt( )
*/

select round( sqrt(pow(max(lat_n) - min(lat_n), 2) + pow(max(long_w) - min(long_W) , 2)  ) , 4) from station;
