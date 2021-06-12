import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] visited;
	static int now;
	static int max = 100001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());

		visited = new int[max + 1];
		for (int i = 0; i <= max; i++) {
			visited[i] = -1;
		}

		if (N >= K) {
			System.out.println(N - K);
		} else
			BFS();

		br.close();
	}

	public static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		now = N;
		q.offer(now);
		visited[now] = 0;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now == K) {
				System.out.println(visited[now]);
				break;
			}

			int next = now * 2;
			while (next <= max && visited[next] == -1) {
				visited[next] = visited[now];
				q.offer(next);
				next = next * 2;
			}

			if (now + 1 <= max && visited[now + 1] == -1) {
				visited[now + 1] = visited[now] + 1;
				q.offer(now + 1);
			}
			if (now - 1 >= 0 && visited[now - 1] == -1) {
				visited[now - 1] = visited[now] + 1;
				q.offer(now - 1);
			}
		}
	}
}
