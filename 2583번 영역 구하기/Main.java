import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int array[][];
	static int group[][];
	static int count = 0;
	static int m = 0;
	static int n = 0;
	static int border_x[] = { -1, 1, 0, 0 };
	static int border_y[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		try {
			StringTokenizer token = new StringTokenizer(br.readLine());
			m = Integer.parseInt(token.nextToken());
			n = Integer.parseInt(token.nextToken());
			int k = Integer.parseInt(token.nextToken());

			array = new int[m][n];

			for (int i = 0; i < k; i++) {
				token = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(token.nextToken());
				int y = Integer.parseInt(token.nextToken());
				int x2 = Integer.parseInt(token.nextToken());
				int y2 = Integer.parseInt(token.nextToken());

				for (int j = y; j < y2; j++) {
					for (int h = x; h < x2; h++) {
						array[j][h] = 1;
					}
				}
			}
			ArrayList<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (array[i][j] == 0) {
						count = 0;
						DFS(i, j);
						list.add(count);
					}
				}
			}
			
			Collections.sort(list);
			sb.append(list.size());
			sb.append("\n");
			for(int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
				sb.append(" ");
			}
			
			System.out.println(sb);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void DFS(int r, int c) {
		array[r][c] = 1;
		count++;

		for (int i = 0; i < 4; i++) {
			int r2 = r + border_x[i];
			int c2 = c + border_y[i];

			if (r2 >= 0 && c2 >= 0 && r2 < m && c2 < n)
				if (array[r2][c2] == 0) {
					DFS(r2, c2);
				}

		}
	}
}
