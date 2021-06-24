import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<scoville.length; i++){
            list.add(scoville[i]);
       }
        
        while(list.get(0) < K){
            if(list.size() <= 1 && list.get(0) < K) return -1;
            list.add(list.get(0) + list.get(1) * 2);
            list.remove(1);
            list.remove(0);
            answer++;
            Collections.sort(list);
        }
        
        return answer;
    }
}