package Study.algorithm_lunchStudy;

import java.io.*;
import java.util.*;

public class BOJ9375_패션왕신해빈 {
    /**
     * 패션왕 신해빈
     * <a href="https://www.acmicpc.net/problem/9375">...</a>
     */

    /*
    chatGPT한테 힌트 받은 부분
    - value를 name 말고 개수로 받아라
    - 안 입는 경우를 포함해서 곱하면 된다!
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            // hashmap 만들어주기
//            Map<String, ArrayList<String>> hashmap = new HashMap<>();
            Map<String, Integer> hashmap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                st.nextToken(); // String name = st.nextToken();
                String type = st.nextToken();

                hashmap.put(type, hashmap.getOrDefault(type, 0) + 1);

//                if (hashmap.containsKey(type)) {
//                    hashmap.get(type).add(name);
//                } else {
//                    hashmap.put(type, new ArrayList<>());
//                    hashmap.get(type).add(name);
            }


            // 입는 옷의 종류 개수 * 그 종류에 속한 옷의 개수
            // 1개만 입을 때 -> name list 개수 다 합해주면 됨
            // 2개만 입을 때 -> 뭐 입을 거임? 종류 두 개 골라주고 -> 그 종류에 속한 옷들 개수 곱해줘
            int result = 1;

            for (int cnt : hashmap.values()) {
                result *= cnt+1;
            }

                System.out.println(result - 1); // 알몸(모든 종류에서 아무것도 안 입는 경우) 제외

        }
    }
}
