package week02.hyunji;

import java.util.Scanner;

public class wed_boj_9095_123더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dp = new int[11];
        
        dp[0] = 1; //아무것도 안더하는 방법 
        dp[1] = 1; //+1
        dp[2] = 2; //1+1, 2 
        
        for (int i = 3; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
