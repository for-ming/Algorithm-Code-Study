import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int c = completion.length;
        int p = participant.length;
        
        Arrays.sort(completion);
        Arrays.sort(participant);
        
        for(int i = 0; i < c; i++){
            if(!completion[i].equals(participant[i])){
                answer = participant[i];
                break;
            }
            else
                answer = participant[i+1];
        }
 
        
        return answer;
    }
}