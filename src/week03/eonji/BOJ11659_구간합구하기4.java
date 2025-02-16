package Study.algorithm_lunchStudy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11659_구간합구하기4 {
    /**
     * 구간합구하기4
     * <a href="https://www.acmicpc.net/problem/11659">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                arr[i] = Integer.parseInt(st.nextToken());
            } else {
                arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if(i == 1) {
                bw.write(arr[j-1] + "\n");
                bw.flush();
            } else {
                bw.write((arr[j - 1] - arr[i - 2]) + "\n");
                bw.flush();
            }
        }
    }
}
