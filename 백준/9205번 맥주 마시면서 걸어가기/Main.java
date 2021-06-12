import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Map {
	int x;
	int y;

	Map(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int t; // 테스트케이스 개수 ~50
	static int n; // 편의점 개수 ~100
	static Map[] map; // x,y 좌표 ( 상근, 편의점, 페스티벌 )
	static Map sg;
	static Map festival;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;

		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new Map[n + 2];
			visited = new boolean[n + 2];
			for (int j = 0; j < n + 2; j++) {
				token = new StringTokenizer(br.readLine());
				map[j] = new Map(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
			}
			sg = map[0];
			festival = map[n + 1];

			if (Math.abs(festival.x - sg.x) + Math.abs(festival.y - sg.y) <= 1000)
				System.out.println("happy");
			else
				BFS(); // 편의점을 반드시 가야할때 확인
		}
		
		br.close();
	}

	public static void BFS() {
		Queue<Map> q = new LinkedList<>();
		q.offer(sg);
		
		int check = 0;
		while (!q.isEmpty()) {
			Map now = q.poll();

			if (now.x == festival.x && now.y == festival.y) {
				System.out.println("happy");
				check = 1;
				break;
			}

			for (int i = 1; i < n + 2; i++) {
				if(Math.abs(now.x - map[i].x) + Math.abs(now.y - map[i].y) <= 1000 && !visited[i]) {
					q.offer(map[i]);
					visited[i] = true;
				}
			}
		}
		
		if(check == 0)
			System.out.println("sad");
	}

}
