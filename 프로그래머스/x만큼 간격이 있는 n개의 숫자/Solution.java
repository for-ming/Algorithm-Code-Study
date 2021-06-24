class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long next = x;
        for(int i=0; i<n; i++){
            answer[i] = next;
            next += x;
        }
        return answer;
    }
}