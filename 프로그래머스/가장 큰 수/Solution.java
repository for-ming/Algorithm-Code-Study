import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] s = new String[numbers.length];
        String answer = "";
        
        for(int i=0; i<numbers.length; i++)
            s[i] =  Integer.toString(numbers[i]);
        
        Arrays.sort(s, new Comparator<String>(){
            //정렬 기준 정의
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        if(s[0].startsWith("0")) answer = "0";
        else{
            for(int i=0; i<s.length; i++){
                answer += s[i];
            }
        }
        return answer;
    }
}