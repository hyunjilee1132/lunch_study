package Study.algorithm_lunchStudy;

import java.io.*;
import java.util.Arrays;

public class BOJ1003 {
    /**
     * 피보나치함수
     * <a href="https://www.acmicpc.net/problem/1003">...</a>
     */

    /*
    걍 피보나치 수열 만들어서 cnt 올려주니까 당연히 시간 초과
    -> 개수를 저장하면서 가면 재귀 한 번씩만 돌릴 수 있어!
    -> f(n-1)에서 f(n-2)의 0, 1 개수 정보를 저장해서 갖고 있고, 그 상태로 f(n) 넘어가면
       f(n-1)만 호출해서 이미 본인이 갖고 있는 f(n-2)의 0, 1 개수 정보랑 f(n-1)까지의 정보랑 더하면 됨
     */

    static int[] cur;   // f(n-1)의 0과 1 개수 저장해줌
    static int[] pre;   // f(n-2)의 0과 1 개수 저장해줌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            cur = new int[2];
            pre = new int[2];
            f(N);
            System.out.println(cur[0] + " " + cur[1]);

        }
    }

    public static int[] f(int n) {
        if (n == 0) {
            cur[0] = 1;
            cur[1] = 0;
            // f(0)에서 개수 정보 (1, 0)
        } else if (n == 1) {
            cur[0] = 0;
            cur[1] = 1;
            // f(1)에서 개수 정보 (0, 1)

//            System.out.println("f(1) 결과 : " + cur[0] + " " + cur[1]);
        } else if (n == 2) {
            f(1);
            pre[0] = cur[0];
            pre[1] = cur[1];
            // f(1)의 개수 정보 (0, 1)
            cur[0] = 1;
            cur[1] = 1;
            // f(2)까지의 개수 정보 (1, 1)

//            System.out.println("f(2) 결과 : " + cur[0] + " " + cur[1]);
//            System.out.println("현재 pre : " + pre[0] + " " + pre[1]);
        } else {
//            System.out.println(n + "들어옴");

            int[] preresult = Arrays.copyOf(f(n - 1), 2);
            // 이 preresult를 안 만들어주면 f(n-1)의 정보를 저장할 수가 없음...
            // pre에 담아버리면 f(n-1)이 갖고 있는 pre 정보를 가져올 수가 없어..
            // 그렇다고 더하고 나서 담으려면 cur 값이 바뀌어서 다른 값이 담김
            // 참조값 복사 조심....preresult = f(n-1)로 했다가 논리오류 찾느라 애 좀 먹었음

//            System.out.println("이제 " + cur[0] + "이랑" + pre[0] + " 더할게");
//            System.out.println("이제 " + cur[1] + "이랑" + pre[1] + " 더할게");

            cur[0] = cur[0] + pre[0];
            cur[1] = cur[1] + pre[1];
            // f(n-1)의 cur가 갖고 있는 값에, pre 값(=f(n-2)까지의 값) 더해서 f(n)까지의 개수 갱신해주고

            pre[0] = preresult[0];
            pre[1] = preresult[1];
            // f(n-1)까지의 개수 저장해줌

//            System.out.println(n + " 시점 현재 pre : " + pre[0] + " " + pre[1]);
//            System.out.println("f(" + n + ") 결과 : " + cur[0] + " " + cur[1]);
        }

        return cur;
    }
}
