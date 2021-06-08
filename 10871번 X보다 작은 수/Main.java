import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");

			int count = Integer.parseInt(token.nextToken());
			int num = Integer.parseInt(token.nextToken());

			token = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < count; i++) {
				int n = Integer.parseInt(token.nextToken());
				if (n < num)
					bw.write(n + " ");
			}

			br.close();
			bw.flush();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
