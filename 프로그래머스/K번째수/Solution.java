import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int target = commands[i][2];

			int[] arr = new int[end - start + 1];
			for (int j = 0; j < (end - start + 1); j++) {
				arr[j] = array[start - 1 + j];
			}
			Arrays.sort(arr);
			answer[i] = arr[target - 1];
		}

		return answer;
	}
}