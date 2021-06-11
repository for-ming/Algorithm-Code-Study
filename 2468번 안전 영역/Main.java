import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int max = 0;
	static int[] tr = { -1, 1, 0, 0 };
	static int[] tc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				if (max < map[i][j])
					max = map[i][j];
			}
		}

		List<Integer> list = new LinkedList<>();

		for (int k = 0; k <= max; k++) {
			int count = 0;
			fill_boolean();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= k && !visited[i][j]) {
						DFS(i, j, k);
						count++;
					}
				}
			}
			list.add(count);
		}

		System.out.println(Collections.max(list));
		br.close();
	}

	public static void fill_boolean() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}

	}

	public static void DFS(int r, int c, int k) {

		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + tr[i];
			int nc = c + tc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (!visited[nr][nc] && map[nr][nc] >= k) {
					DFS(nr, nc, k);
				}
			}
		}
	}
}
