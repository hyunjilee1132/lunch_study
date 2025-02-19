package groupstudy.algorithm_lunchStudy;

import java.io.*;

public class BOJ11727_2xN타일링2 {
    /**
     * 2xN 타일링 2
     * <a href="https://www.acmicpc.net/problem/11727">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
            dp[2] = 3;
            dp[3] = dp[1] * 2 + dp[2];
            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;

        }
        System.out.println(dp[n]);
    }
}
