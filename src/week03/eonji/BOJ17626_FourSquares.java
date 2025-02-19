package groupstudy.algorithm_lunchStudy;

import java.io.*;

public class BOJ17626_FourSquares {
    public static void main(String[] args) throws IOException {
        /*
        처음에는 최대 제곱수 빼고 남은 나머지 인덱스로 찾아서 +1 해주면 되겠다 했는데
        최대제곱수 이전까지 제곱수 다 빼보면서 최소값 찾아야 하는 거였음
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] square = new int[224];
        for (int i = 1; i < 224; i++) {
            square[i] = i * i;
        }

        int[] dp = new int[N+1];

        for(int i = 1; i <= N ; i++) {
            dp[i] = i;
        }

        for(int i = 1; i * i <= N ; i++) {
            int sqr = i*i;
            for (int j = sqr ; j <= N ; j++) {
                dp[j] = Math.min(dp[j-sqr]+1, dp[j]);
            }
        }

        System.out.println(dp[N]);

    }
}
