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
        
        //�Ҿ���ȴµ� ������ �ִ� �л� ����
         for(int i=0; i<lost.length; i++){
             for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    reserve[j] = 0;
                    lost[i] = 0;
                }
             }
        }
        
        //���� �� �ִ� ü���� ����
         for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j]-1 && lost[i] != 0){
                    po[i]++;
                }
            }
        }
        
        // 1�����׸� ���� �� �ִ� ��� �켱������ ������
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
        
        // 2������ ���� �� ������ �켱���� ���߿�
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