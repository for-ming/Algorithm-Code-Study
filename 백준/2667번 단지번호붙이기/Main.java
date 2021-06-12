import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] updown = { -1, 1, 0, 0 };
	static int[] leftright = { 0, 0, -1, 1 };
	static int count = 0;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		try {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String buf = br.readLine(); 
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(buf.split("")[j]);
				}
			}

			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count = 0;
					if (map[i][j] == 1 && !visited[i][j]) {
						count++;
						DFS(i, j);
						list.add(count);
					}
				}
			}

			Collections.sort(list);
			sb.append(list.size());
			sb.append("\n");
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
				sb.append("\n");
			}
			System.out.println(sb);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void DFS(int r, int c) {
		
		visited[r][c] = true;

		for (int k = 0; k < 4; k++) {
			int r2 = r + updown[k];
			int c2 = c + leftright[k];

			if (r2 >= 0 && c2 >= 0 && r2 < N && c2 < N) {
				if (map[r2][c2] == 1 && !visited[r2][c2]) {
					count++;	
					DFS(r2, c2);
				}
			}
		}
	}
}
