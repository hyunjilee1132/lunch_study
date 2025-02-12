package lunch_study.src.week02.eonji;

import java.io.*;
import java.util.*;

public class BOJ9375_패션왕신해빈 {
    /**
     * 패션왕 신해빈
     * <a href="https://www.acmicpc.net/problem/9375">...</a>
     */

    /*
    chatGPT한테 힌트 받은 부분
    - 안 입는 경우를 포함해서 곱하면 된다!
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> hashmap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                st.nextToken(); // String name = st.nextToken();
                String type = st.nextToken();

                hashmap.put(type, hashmap.getOrDefault(type, 0) + 1);
            }

            int result = 1;

            for (int cnt : hashmap.values()) {
                result *= cnt+1;
            }

                System.out.println(result - 1);

        }
    }
}
