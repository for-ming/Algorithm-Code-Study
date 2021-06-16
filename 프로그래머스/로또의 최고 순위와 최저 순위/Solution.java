import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int max = 0; 
        int min = 0;
        
        int count = 0;
        int zero = 0;
        
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(lottos[i] == win_nums[j])
                    count++;
            }
            if(lottos[i] == 0)
                    zero++;
        }
        
        System.out.println(count + " " + zero);
        max = 7 - (count + zero);
        min = 7 - count;
        
        if(count == 0) min = 6;
        if(count == 0 && zero == 0) max = 6;
        
        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
}