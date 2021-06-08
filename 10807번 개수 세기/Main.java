import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int array[] = new int[n];

			StringTokenizer token = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(token.nextToken());
			}

			int v = Integer.parseInt(br.readLine());
			int count = 0;

			for (int i = 0; i < n; i++) {
				if (array[i] == v)
					count++;
			}

			System.out.println(count);

			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
