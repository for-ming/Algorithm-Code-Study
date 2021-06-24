class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        String[] check = s.split("");
        
        if(check.length == 4 || check.length == 6){
            for(int i=0; i<check.length; i++){
                if((int)s.charAt(i) > 96) answer = false;
            }
        }
        else return false;
        
        return answer;
    }
}