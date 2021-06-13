import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M; // 3~300
	static int[][] Ice; // 빙산 0~10
	static int[][] water;
	static boolean[][] visited;
	static int Max = 10000;
	static int year = 0;
	static int count;
	static int[] tr = { -1, 1, 0, 0 };
	static int[] tc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());

		Ice = new int[N][M];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Ice[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		while (count < 2) {

			if (!check_ice()) {
				year = 0;
				break;
			}
			
			count = 0;
			visited = new boolean[N][M];
			water = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (Ice[i][j] != 0 && !visited[i][j]) {
						DFS(i, j);
						count++;
					}
				}
			}
			if(count > 1) {
				break;
			}
			next_year();
		}
		System.out.println(year);
		br.close();
	}

	public static void DFS(int r, int c) {
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int x = r + tr[i];
			int y = c + tc[i];
			if(x >= 0 && y >= 0 && x < N && y < M) {
				if(Ice[x][y] == 0) {
					water[r][c]++;	 //DFS를 돌며 빙산이 있는 위치에서 주위 바다 영역을 미리 체크해둔 뒤, 다음 해에 한번에 녹이기!
				}
				if(!visited[x][y] && Ice[x][y] > 0) {
					DFS(x, y);
				}
			}
		}

	}
	
	private static void next_year() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Ice[i][j] != 0) {
					if(Ice[i][j] - water[i][j] < 0)
						Ice[i][j] = 0;
					else
						Ice[i][j] = Ice[i][j] - water[i][j];
				}
			}
		}
		year++;
	}
	
	public static boolean check_ice() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Ice[i][j] != 0)
					return true;
			}
		}
		return false; // 얼음이 다 녹았으면 false
	}
}
