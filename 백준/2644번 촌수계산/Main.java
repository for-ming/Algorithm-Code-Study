import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Person {
	int x; // 부모
	int y; // 자식

	Person(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n; // 사람의 수
	static int m; // 관계의 수
	static int person1;
	static int person2;
	static int max = 100;
	static Person[] every;
	static int[] check;
	static int start;
	static int find;
	static int find2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer token = new StringTokenizer(br.readLine());
		person1 = Integer.parseInt(token.nextToken());
		person2 = Integer.parseInt(token.nextToken());

		m = Integer.parseInt(br.readLine());
		every = new Person[m];
		check = new int[m];
		
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(token.nextToken());
			int child = Integer.parseInt(token.nextToken());
			every[i] = new Person(parent, child);
			if(child == person1) {
				start = i;
				find = person2;
			}
			else if(child == person2) {
				start = i;
				find = person1;
			}
		}
		
		if(person1 == person2)
			System.out.println(0);
		else BFS();
		
		br.close();
	}
	
	public static void BFS() {
		Queue<Person> q = new LinkedList<>();
		Queue<Integer> qq = new LinkedList<>();
		q.offer(every[start]);
		qq.offer(start);
		check[start] = 0;
		int who = 0;
		int count = 0;
		
		while(!q.isEmpty()) {
			Person p = q.poll();
			int num = qq.poll();
			//System.out.println(p.x + " " + p.y);
			
			if(p.y == find || p.x == find) {
				System.out.println(check[num] + 1);
				who = 1;
				break;
			}
			
			for(int i=0; i<m; i++) {
				if((every[i].x == p.x || every[i].y == p.x) && check[i]==0) {
					check[i]= check[num] + 1;
					q.offer(every[i]);
					qq.offer(i);
					count++;
				}
				
				if( every[i].x == p.y && check[i]==0) {
					check[i]= check[num] + 1;
					q.offer(every[i]);
					qq.offer(i);
					count++;
				}
			}
				
		}
		
		if(who == 0) {
			System.out.println(-1);
		}
	}
}
