package lunch_study;
import java.util.*;
import java.io.*;
public class BOJ11047 {
    /**
     * 동전
     * <a href="https://www.acmicpc.net/problem/11047">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        // k보다 큰 동전들은 빼고 stack에 담아줌
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num <= k) {
                stack.add(num);
            } else {
                br.close();
                break;
            }
        }
        // stack에서 제일 큰 애로 최대한 금액 채워주고
        // 그 다음 큰 애로 또 채워주고...
        while(!stack.isEmpty() && k > 0) {
            int coin = stack.pop();
            cnt += k/coin;
            k = k - coin*(k/coin);
        }
        System.out.println(cnt);
    }
}