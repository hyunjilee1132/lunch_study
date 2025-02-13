package Study.algorithm_lunchStudy;

import java.util.Scanner;

public class BOJ9461_파도반수열 {
    /**
     * 파도반수열
     * <a href="https://www.acmicpc.net/problem/9461">...</a>
     */

    /*
    dp 배열을 int로 쓰니까 틀렸다고 함... 범위를 넘어갔나봄...그래서 long으로 썼어
    근데 이걸 문제만 보고 어케 int 써야할지 long 써야할지 판단하지?
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = dp[3] + dp[5];
        dp[7] = dp[2] + dp[6];
        dp[8] = dp[1] + dp[7];
        for(int i = 9 ; i < 101 ; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        for(int t = 1 ; t <= T ; t++) {
            int N = sc.nextInt();

            System.out.println(dp[N]);
        }
    }
}
