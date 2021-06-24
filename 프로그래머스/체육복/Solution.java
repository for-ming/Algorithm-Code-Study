import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int lostoo = 0;
        int[] po = new int[lost.length];
        int count = 0;
        
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //잃어버렸는데 여분이 있는 학생 제외
         for(int i=0; i<lost.length; i++){
             for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    reserve[j] = 0;
                    lost[i] = 0;
                }
             }
        }
        
        //빌릴 수 있는 체육복 개수
         for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j]-1 && lost[i] != 0){
                    po[i]++;
                }
            }
        }
        
        // 1명한테만 빌릴 수 있는 경우 우선순위로 빌려줌
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j]-1 && lost[i] != 0){
                    if(po[i] == 1 && reserve[j]!=0 && !list.contains(reserve[j])){
                        list.add(reserve[j]);
                        reserve[j] = 0;
                        lost[i] = 0;
                    }
                }
            }
        }
        
        // 2명한테 빌릴 수 있으면 우선순위 나중에
         for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j]-1 && lost[i] != 0){
                    if(po[i] == 2 && reserve[j]!=0 && !list.contains(reserve[j])){
                        list.add(reserve[j]);
                        reserve[j] = 0;
                        lost[i] = 0;
                    }
                }
            }
            if(lost[i] != 0) lostoo++;
        }
        
        answer = n - lostoo;
        if(lost.length == 0) answer = n;
        if(list.size() > lost.length) answer = n;
        
      
        return answer;
    }
}