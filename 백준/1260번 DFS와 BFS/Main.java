import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; // 정점 개수
	static int M; // 간선 개수
	static int start; // 탐색 시작 정점 V
	static int[][] map;
	static int[] check_DFS;
	static int[] check_BFS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		start = Integer.parseInt(token.nextToken());

		map = new int[N + 1][N + 1];
		check_DFS = new int[N + 1];
		check_BFS = new int[N + 1];

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());

			int num1 = Integer.parseInt(token.nextToken());
			int num2 = Integer.parseInt(token.nextToken());

			map[num1][num2] = map[num2][num1] = 1;
		}
		System.out.print(start + " ");
		DFS(start);
		System.out.println();
		BFS();
	}

	private static void DFS(int x) {
		check_DFS[x] = 1;

		for (int i = 0; i < N + 1; i++) {
			if (check_DFS[i] == 0 && map[x][i] == 1) {
				check_DFS[i] = 1;
				System.out.print(i + " ");
				DFS(i);
			}
		}
	}

	private static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		check_BFS[start] = 1;
		System.out.print(start + " ");

		while(!q.isEmpty()) {
			int num = q.poll();
			for (int i = 0; i < N + 1; i++) {
				if (check_BFS[i] == 0 && map[num][i] == 1) {
					System.out.print(i + " ");
					check_BFS[i] = 1;
					q.offer(i);
				}
			}
		}
	}
}
