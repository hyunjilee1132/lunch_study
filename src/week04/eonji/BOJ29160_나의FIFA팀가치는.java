package groupstudy.algorithm_lunchStudy;

import java.io.*;
import java.util.*;

public class BOJ29160_나의FIFA팀가치는 {
    /**
     * 나의 FIFA 팀 가치는?
     * <a href="https://www.acmicpc.net/problem/29160">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<PriorityQueue<Integer>> positions = new ArrayList<>();

        for(int i = 0 ; i < 12 ; i++) {
            positions.add(new PriorityQueue<>(Collections.reverseOrder()));
        }

        for(int i = 0 ; i < N ; i++) {
            input = br.readLine().split(" ");
            int P = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            positions.get(P).offer(W);
        }

        // 3월 더해줘
        int[] selected = new int[12];
        for(int i = 0 ; i < 12 ; i++){
            if(!positions.get(i).isEmpty()) {
                selected[i] = positions.get(i).poll();
            }
        }

        while(K-- > 0) {
            // 8월 빼줘
            for (int i = 1; i < 12; i++) {
                positions.get(i).offer(Math.max(selected[i] - 1,0));
            }

            // 11월 다시 재구성
            for (int i = 1; i < 12; i++) {
                if (!positions.get(i).isEmpty()) {
                    selected[i] = positions.get(i).poll();
                }
            }
        }

        int sum = 0;
        for(int i = 1 ; i < 12 ; i++) {
            sum += selected[i];
        }

        System.out.println(sum);
    }
}
