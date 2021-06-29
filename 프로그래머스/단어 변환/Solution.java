import java.util.*;
class Word{
    String s;
    int count;
    Word(String s, int count){
        this.s = s;
        this.count = count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Word[] word = new Word[words.length];
        for(int i=0; i<words.length; i++){
            word[i] = new Word(words[i], 0);
        }
        
        answer = BFS(begin, target, word);
        return answer;
    }
    
    public int BFS(String begin, String target, Word[] word){
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word w = q.poll();
            if(w.s.equals(target)) return w.count; 
            
            for(int i=0; i < word.length; i++){
                int count = 0;
                for(int j=0; j < w.s.length(); j++){
                    if(word[i].s.charAt(j) == w.s.charAt(j))
                        count++;
                }
                if(count == w.s.length()-1 && word[i].count == 0){
                    q.offer(word[i]);
                    word[i].count = w.count+1;
                }
            }  
        }
        return 0;   
    }
}