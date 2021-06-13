import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int com;
	static int N;
	static int[][] relation;
	static int[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		com = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		relation = new int[com + 1][com + 1];
		check = new int[com + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			relation[x][y] = 1;
			relation[y][x] = 1;
		}
		BFS();
	}

	public static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		check[1] = 1;

		int count = 0;
		while (!q.isEmpty()) {
			int virus = q.poll();

			for (int i = 1; i < com + 1; i++) {
				if (relation[virus][i] == 1 && check[i] == 0) {
					q.offer(i);
					check[i] = 1;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
