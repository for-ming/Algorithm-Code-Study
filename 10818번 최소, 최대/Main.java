import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		try {
			int n = Integer.parseInt(br.readLine());
			int array[] = new int[n];
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(token.nextToken());
			}

			Arrays.sort(array);
			sb.append(array[0]);
			sb.append(" ");
			sb.append(array[n - 1]);

			System.out.println(sb);

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
