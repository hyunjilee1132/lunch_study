package week01.hyunji;

import java.io.*;

public class thu_boj_1003_피보나치함수 {
    public static void main(String[] args) throws IOException {
        //피보나치 - O(n)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] dp = new int[41][2]; //0<=n<=40, 행: 들어오는 값, 열: 0과 1의 개수 저장

        dp[0][0] = 1; dp[0][1] = 0; //0: 0 => 0이 1개 들어있다 => [0][0] = 1
        dp[1][0] = 0; dp[1][1] = 1; //1: 1 => 1이 1개 들어있다 => [1][1] = 1

        //f(n) = f(n-2) + f(n-1)
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-2][0] + dp[i-1][0]; //연산하고 나오는 0의 개수
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
        
    }
}