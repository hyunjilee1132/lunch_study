import java.io.*;
import java.util.Arrays;

public class fri_boj_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1]; // DP 테이블
        System.out.printf("dp의 초기값 : %s\n", Arrays.toString(dp));

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 빼는 경우
            System.out.printf("dp 테이블의 변화 -1 : %s\n", Arrays.toString(dp));

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나누는 경우
                System.out.printf("dp 테이블의 변화 /2 : %s\n", Arrays.toString(dp));
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나누는 경우
                System.out.printf("dp 테이블의 변화 /3 : %s\n", Arrays.toString(dp));
            }
            System.out.printf("index : %d\n", i);
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
