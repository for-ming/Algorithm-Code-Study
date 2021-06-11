import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F; // 전체 층
	static int S; // 시작 층
	static int G; // 목표 층
	static int U; // 위로 올라가는 단위
	static int D; // 아래로 내려가는 단위
	static int now;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		F = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		G = Integer.parseInt(token.nextToken());
		U = Integer.parseInt(token.nextToken());
		D = Integer.parseInt(token.nextToken());

		visited = new int[F + 1];
		BFS();

		br.close();
	}

	public static void BFS() {
		now = S;
		Queue<Integer> q = new LinkedList<>();
		q.offer(now);
		visited[now] = 1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now == G) {
				System.out.println(visited[now] - 1);
				break;
			} else {
				if (now + U > 0 && now + U <= F && visited[now + U] == 0) {
					q.offer(now + U);
					visited[now + U] = visited[now] + 1;
				}

				if (now - D > 0 && now - D <= F && visited[now - D] == 0) {
					q.offer(now - D);
					visited[now - D] = visited[now] + 1;
				}
			}
		}

		if (visited[G] == 0)
			System.out.println("use the stairs");
	}
}
