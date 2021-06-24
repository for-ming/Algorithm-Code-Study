class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String[] find = s.split("");
        int count_p = 0;
        int count_y = 0;
        
        for(int i=0; i<find.length; i++){
            if(find[i].equals("P") || find[i].equals("p"))
                count_p++;
            else if(find[i].equals("Y") || find[i].equals("y"))
                count_y++;
        }
        System.out.println(count_p + " "+ count_y);
        if(count_p != count_y) answer = false;

        return answer;
    }
}