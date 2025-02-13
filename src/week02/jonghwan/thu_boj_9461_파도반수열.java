package jonghwan;

import java.util.Scanner;

public class thu_boj_9461_파도반수열 {
	public static void main(String args[]) throws Exception
	{
		long[] dp = new long[101];
		int[] initial = {0, 1, 1, 1, 2, 2};
		
		for (int i = 1; i < 101; i++) {
			if ( i < initial.length) {
				dp[i] = initial[i];
			} else {
				dp[i] = dp[i-1] + dp[i-5];
			}
		}
		
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
		
		
	}
}
