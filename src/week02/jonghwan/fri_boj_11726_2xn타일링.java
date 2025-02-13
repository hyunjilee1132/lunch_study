package jonghwan;

import java.util.Scanner;

public class fri_boj_11726_2xn타일링 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int [] dp = new int[1001];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i < 1001; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 10007;
		}
		
		System.out.println(dp[sc.nextInt()]);

		
	}
}
