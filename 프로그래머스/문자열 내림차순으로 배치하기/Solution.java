import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] token = s.split("");
        Arrays.sort(token, Collections.reverseOrder());
        answer = String.join("", token);
        return answer;
    }
}