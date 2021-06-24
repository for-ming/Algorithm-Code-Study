//È¿À²¼º UP
import java.util.*;

class Solution2 {
    public int solution2(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            queue.offer(scoville[i]);
       }
        
        while(queue.peek() < K){
            if(queue.size() <= 1) return -1;
            int num = queue.poll();
            int num2 = queue.poll();
            
            queue.offer(num + num2 * 2);
            answer++;
        }
        
        return answer;
    }
}