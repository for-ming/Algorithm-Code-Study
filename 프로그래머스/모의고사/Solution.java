class Solution {
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] p1 = { 1, 2, 3, 4, 5 }; // 5
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10
		int[] num = { 0, 0, 0 };

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == p1[i % 5])
				num[0]++;
			if (answers[i] == p2[i % 8])
				num[1]++;
			if (answers[i] == p3[i % 10])
				num[2]++;
		}

		if (num[0] == num[1] && num[1] == num[2]) {
			answer = new int[3];
			answer[0] = 1;
			answer[1] = 2;
			answer[2] = 3;
		} else if (num[0] == num[1] && num[0] > num[2]) {
			answer = new int[2];
			answer[0] = 1;
			answer[1] = 2;
		} else if (num[0] == num[2] && num[0] > num[1]) {
			answer = new int[2];
			answer[0] = 1;
			answer[1] = 3;
		} else if (num[1] == num[2] && num[1] > num[0]) {
			answer = new int[2];
			answer[0] = 2;
			answer[1] = 3;
		} else if (num[0] > num[1] && num[0] > num[2]) {
			answer = new int[1];
			answer[0] = 1;
		} else if (num[1] > num[0] && num[1] > num[2]) {
			answer = new int[1];
			answer[0] = 2;
		} else if (num[2] > num[1] && num[2] > num[0]) {
			answer = new int[1];
			answer[0] = 3;
		}

		return answer;
	}
}