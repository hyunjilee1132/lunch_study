package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 나의 FIFA 팀 가치는?
public class BOJ29160 {
    final static int NUMBER_OF_POSITIONS = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Queue<Integer>> arr = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 최대 힙으로 구현
        for (int i = 0; i < NUMBER_OF_POSITIONS; i++) {
            arr.add(new PriorityQueue<>(Collections.reverseOrder()));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr.get(key - 1).offer(value);
        }

        // pq배열을 돌면서, 하나의 최대힙당 k번만큼 -1을 한다.
        for (int i = 0; i < NUMBER_OF_POSITIONS; i++) {
            Queue<Integer> temp = arr.get(i);
            for (int j = 0; j < k; j++) {
                if (!temp.isEmpty()) {
                    int num = temp.poll() - 1;
                    temp.offer(Math.max(num, 0));
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < NUMBER_OF_POSITIONS; i++) {
            Queue<Integer> temp = arr.get(i);
            if (!temp.isEmpty()) {
                answer += temp.poll();
            }
        }
        System.out.println(answer);
    }
}
