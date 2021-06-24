import java.util.*;

class Solution1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int c = completion.length;
        int p = participant.length;
        int[] result = new int[p];

        for(int i=0; i<c; i++){
            for(int j=0; j<p; j++){
                if(completion[i].equals(participant[j])){
                    result[j] = 1;
                    participant[j] = "";
                    break;
                }
            }
        }
        
        for(int j=0; j<p; j++){
            if(result[j] == 0)
                answer = participant[j];
        }
        
        return answer;
    }
}