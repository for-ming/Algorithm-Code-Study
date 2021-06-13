import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Miro {
	int x;
	int y;

	Miro(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] visited;
	static int[] tx = { -1, 1, 0, 0 };
	static int[] ty = { 0, 0, -1, 1 };
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());

		map = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.split("")[j]);
			}
		}

		BFS();
		
		br.close();
	}

	private static void BFS() {
		Queue<Miro> miro = new LinkedList<>();
		miro.offer(new Miro(0, 0));
		Miro destination = new Miro(N - 1, M - 1);
		visited[0][0] = 1;

		while (!miro.isEmpty()) {
			Miro m = miro.poll();

			if (m.equals(destination)) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int xx = m.x + tx[i];
				int yy = m.y + ty[i];

				if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
					if (map[xx][yy] == 1 && visited[xx][yy] == 0 || visited[xx][yy] == visited[m.x][m.y]) {
						visited[xx][yy] = visited[m.x][m.y] + 1;
						miro.offer(new Miro(xx, yy));
					}
				}
			}
		}
		System.out.println(visited[N-1][M-1]);
	}
	
}
