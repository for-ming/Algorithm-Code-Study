import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String[][] map;
	static String[][] map_n;
	static boolean[][] visited;
	static boolean[][] visited_n;
	static int n;
	static int[] tr = { -1, 1, 0, 0 };
	static int[] tc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(br.readLine());

			map = new String[n][n];
			map_n = new String[n][n];
			visited = new boolean[n][n];
			visited_n = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				String next = br.readLine();
				for (int j = 0; j < n; j++) {
					String s = next.split("")[j];
					map[i][j] = s;
					if(s.equals("G"))
						map_n[i][j] = "R";
					else
						map_n[i][j] = s;
				}
			}
			
			int count = 0;
			int n_count = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j].equals("R") && !visited[i][j]) {
						DFS(i, j);
						count++;
					} else if (map[i][j].equals("G") && !visited[i][j]) {
						DFS(i, j);
						count++;
					} else if (map[i][j].equals("B") && !visited[i][j]) {
						DFS(i, j);
						count++;
					}
					
					if (map_n[i][j].equals("R") && !visited_n[i][j]) {
						DFS_N(i, j);
						n_count++;
					} else if (map_n[i][j].equals("B") && !visited_n[i][j]) {
						DFS_N(i, j);
						n_count++;
					}
					
				}
			}

			System.out.println(count + " " + n_count);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void DFS(int r, int c) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + tr[i];
			int nc = c + tc[i];

			if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
				if (map[nr][nc].equals(map[r][c]) && !visited[nr][nc])
					DFS(nr, nc);
			}
		}
	}

	public static void DFS_N(int r, int c) {
		visited_n[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + tr[i];
			int nc = c + tc[i];

			if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
				if (map_n[nr][nc].equals(map_n[r][c]) && !visited_n[nr][nc])
					DFS_N(nr, nc);
			}
		}
	}
}
