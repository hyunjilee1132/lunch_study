package groupstudy.algorithm_lunchStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ28066_타노스는요세푸스가밉다 {
    /**
     * 타노스는 요세푸스가 밉다
     * <a href="https://www.acmicpc.net/problem/28066">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        while(deque.size()>=K) {
            int temp = deque.pop();
            for (int i = 0; i < K - 1; i++) deque.pop();
            deque.offer(temp);
        }

        System.out.println(deque.poll());
    }
}
