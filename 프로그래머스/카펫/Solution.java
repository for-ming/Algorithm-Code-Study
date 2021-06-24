class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int a = 0;
        int b = 0;
        int max = 2500;
            
        for(int i=1; i < max+1; i++){
            for(int j = 1; j < max+1; j++){
                if(((i+j-2)*2 == brown) && ((i-2)*(j-2) == yellow)){
                    if(i <= j){
                        a = j;
                        b = i;
                    }
                    else{
                        a = i;
                        b = j;
                    }
                    break;
                }
            }
        } 
        
        answer[0] = a;
        answer[1] = b;
        return answer;
    }
}