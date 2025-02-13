package Study.algorithm_lunchStudy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11659_구간합구하기4_시간초과 {
    /**
     * 구간합구하기4
     * <a href="https://www.acmicpc.net/problem/11659">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int x = i - 1; x < j ; x++) {
                sum += arr[x];
            }


            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(sum + "\n");
            bw.flush();
        }
    }
}
