package BOJ.forming.step3_1;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt();
		int new_num = num;
		int cycle = 0;
		
		while(true)
		{	
			cycle++;
			int sum = new_num/10 + new_num%10; //자리수 합
			new_num = new_num%10 * 10 + sum%10;
			
			if(num == new_num)
				break;
		}
		System.out.println(cycle);
	}
}
