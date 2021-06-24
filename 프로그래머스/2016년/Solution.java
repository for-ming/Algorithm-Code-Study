class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] date = {"FRI", "SAT", "SUN","MON", "TUE", "WED", "THU"};
        int[] year = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = b-1;
        
        for(int i = 0 ; i < a-1; i++){
            day += year[i];    
        }
        
        day = day % 7;
        
        answer = date[day];
        
        return answer;
    }
}