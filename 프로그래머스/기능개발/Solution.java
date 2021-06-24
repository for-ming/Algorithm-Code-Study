import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) day++;

            q.offer(day);
        }
        
        List<Integer> list_d = new ArrayList<>();
 
        while(!q.isEmpty()){
            int num = q.poll();
            int count = 1;
            while(q.size() > 0 && q.peek() <= num){
                count++;
                q.poll();
            }
            list_d.add(count);
        }
        
        int[] answer = new int[list_d.size()];
        for(int i=0; i<list_d.size(); i++){
            answer[i] = list_d.get(i);
        }
        
        return answer;
    }
}