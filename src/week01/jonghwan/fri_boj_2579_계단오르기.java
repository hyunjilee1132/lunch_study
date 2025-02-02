package week1;

import java.util.Scanner;

public class fri_boj_2579_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// n단계 까지의 최고 점수
		// 
		
		int steps = sc.nextInt();
		
		int[] arr = new int[steps+1];
		
		for (int i = 1; i <= steps; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 연속계단 중 몇번째인지 파악하기 위한 이차원 배열
		int[][] dp = new int[steps+1][2];
		
		dp[1][0] = arr[1];
		
		for (int i = 2; i <= steps; i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + arr[i];
			dp[i][1] = Math.max(dp[i-1][0], dp[i-2][1]) + arr[i];
		}
		
		System.out.println(Math.max(dp[steps][0], dp[steps][1]));
		
		 
	}
}
