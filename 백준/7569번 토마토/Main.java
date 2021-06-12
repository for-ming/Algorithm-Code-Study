import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x;
	int y;
	int z;

	Tomato(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int M;
	static int N;
	static int H;
	static int[][][] box;
	static int count = 0;
	static int[] zz = { -1, 1, 0, 0, 0, 0 };
	static int[] yy = { 0, 0, -1, 1, 0, 0 };
	static int[] xx = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer token = new StringTokenizer(br.readLine());

			M = Integer.parseInt(token.nextToken());
			N = Integer.parseInt(token.nextToken());
			H = Integer.parseInt(token.nextToken());
			box = new int[N][M][H];

			for (int k = 0; k < H; k++) {
				for (int i = 0; i < N; i++) {
					token = new StringTokenizer(br.readLine());
					for (int j = 0; j < M; j++) {
						box[i][j][k] = Integer.parseInt(token.nextToken());
						if (box[i][j][k] == 0)
							count++;
					}
				}

			}

			if (count == 0) {
				System.out.println(0);
				return;
			}

			BFS();

			for (int k = 0; k < H; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (box[i][j][k] == 0) {
							System.out.println(-1);
							return;
						}

					}
				}
			}

			System.out.println(count - 1);
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void BFS() {
		Queue<Tomato> q = new LinkedList<Tomato>();
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j][k] == 1) {
						q.offer(new Tomato(i, j, k));
					}

				}
			}
		}

		while (!q.isEmpty()) {
			Tomato tomato = q.poll();

			for (int i = 0; i < 6; i++) {
				int new_x = tomato.x + xx[i];
				int new_y = tomato.y + yy[i];
				int new_z = tomato.z + zz[i];

				if (new_x >= 0 && new_y >= 0 && new_z >= 0 && new_x < N && new_y < M && new_z < H) {
					if (box[new_x][new_y][new_z] == 0) {
						box[new_x][new_y][new_z] = box[tomato.x][tomato.y][tomato.z] + 1;
						q.offer(new Tomato(new_x, new_y, new_z));
					}
				}
			}
		}

		count = 1;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (count < box[i][j][k]) {
						count = box[i][j][k];
					}
				}
			}
		}
	}

}
