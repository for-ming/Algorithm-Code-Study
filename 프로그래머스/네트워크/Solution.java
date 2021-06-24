import java.util.*;

class Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
       
        for(int i=0; i < computers.length; i++){
            if(!visited[i]){
                DFS(computers, visited, i);
                answer++;
            }
        }
            
        return answer;
    }
    
    public void DFS(int[][] computers, boolean[] visited, int i){
        visited[i] = true;
        
         for(int j=0; j < computers.length; j++){
            if(computers[i][j] == 1 && !visited[j]){
                DFS(computers, visited, j);
            }
        }
    }

}