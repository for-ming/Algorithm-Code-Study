import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());

			for (int i = n; i >= 1; i--)
				wr.write(i + "\n");

			br.close();
			wr.flush();
			wr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
