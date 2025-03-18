package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ12907_동물원_틀림 {

    static int N;
    static int[] arr, res;
    static int num1, num2;
    static int ans = 0;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        vis = new boolean[N];
        arr = new int[N];
        int[] cnt = new int[41];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(temp[i]);
            cnt[arr[i]]++;
        }


        num1 = 0;   // 더 작은 그룹에 몇 마리?
        num2 = 0;   // 더 큰 그룹에 몇 마리?
        for (int i = 0; i < cnt.length; i++) {
            // 조합을 만들 수 없는 경우 처리
            // 1. 세 마리 이상이 같은 순위를 답했을 때
            // 2. 중간에 빈 순위가 있을 때
            if (cnt[i] > 2 || (i != 0 && cnt[i] > cnt[i - 1])) {
                System.out.println(0);
                return;
            }

            // cnt 2가 끝나는 위치, cnt 1이 끝나는 위치 저장 -> res 개수로 만들어줄 거라 +1
            if (i != 0) {
                if(cnt[i] == 2) num1 = i+1;
                else if (cnt[i] == 1) num2 = i+1;
            }
        }

        if(num1 != 0) {
            res = new int[num1];
        } else {
            res = new int[num2];
        }

        // 조합 만들기
        // 더 작은 그룹에 채워넣기 * 2 - 토끼 고양이
        zoo(0);
        System.out.println(ans * 2);

    }


    public static void zoo(int index) {
        if (index == num1) {
            System.out.println(Arrays.toString(res));
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == index && !vis[i]) {
                res[index] = i;
                vis[i] = true;
                zoo(index + 1);
                vis[i] = false;
            }
        }
    }
}
