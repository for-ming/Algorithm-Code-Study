import java.util.*;

class Solution {
    List<String> answers = new ArrayList<>();
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        int count = 0;
        DFS(count, "ICN", "ICN", tickets);
        
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" "); 
        return answer;
    }
    
    public void DFS(int count, String start, String t, String[][]tickets) {
        if(count == tickets.length){
            answers.add(t);
            return;
        }
         for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                DFS(count+1, tickets[i][1], t+" " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
        return;
    }
}