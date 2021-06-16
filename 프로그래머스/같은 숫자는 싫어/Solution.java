import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int temp = 0;
        for(int i=0; i<arr.length; i++){
            if(i<arr.length-1)
                temp = arr[i+1];
            else
                temp = 10;
            
            if(temp == arr[i]){
                continue;
            }
            else{
                list.add(arr[i]);
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}