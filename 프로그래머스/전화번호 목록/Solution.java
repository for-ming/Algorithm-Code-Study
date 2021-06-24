import java.util.*;

//È¿À²¼º X
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0; i<phone_book.length-1; i++){
            for(int j=i+1; j<phone_book.length; j++){
                String s1 = phone_book[i];
                String s2 = phone_book[j];
                if(s2.startsWith(s1) || s1.startsWith(s2)){
                    return false;
                }
            }
        }
        return answer;
    }
}