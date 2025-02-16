package workingon;

import java.util.Scanner;

public class BOJ11726_2xN타일링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        // dp의 인덱스는 전체 길이 n
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i < dp.length ; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }

        System.out.println(dp[n]);

    }
}
