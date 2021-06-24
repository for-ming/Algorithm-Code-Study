class Solution {
    
    public static int solution(int[] numbers, int target) {
		int answer = 0;
        int sum = 0;
		
		answer = DFS(numbers, target, 0, sum);
              
		return answer;
	}

	public static int DFS(int[] numbers, int target, int number, int sum) {
		if (sum == target && number == numbers.length)
			return 1;
        else if(number == numbers.length) 
            return 0;
        
        int result = 0;
        result = DFS(numbers, target, number+1, sum + numbers[number]) + DFS(numbers, target, number+1, sum - numbers[number]) ;
        
       return result;
	}
    
}