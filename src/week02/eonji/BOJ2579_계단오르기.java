package Study.algorithm_lunchStudy;

import java.util.Scanner;

public class BOJ2579_계단오르기 {
    /**
     * 계단 오르기
     * <a href="https://www.acmicpc.net/problem/2579">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[301];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] cost = new int[301];

        cost[1] = arr[1];
        cost[2] = arr[1] + arr[2];
        cost[3] = Math.max(cost[1] + arr[3], arr[3] + arr[2]);
//        cost[4] = Math.max(cost[2] + arr[4], arr[4] + arr[3] + cost[1]);
//        cost[5] = Math.max(cost[3] + arr[5], arr[5] + arr[4] + cost[2]);
//        cost[6] = Math.max(cost[4] + arr[6], arr[6] + arr[5] + cost[3]);

        for (int i = 4; i <= N; i++) {
            cost[i] = Math.max(cost[i - 2] + arr[i], arr[i] + arr[i - 1] + cost[i - 3]);
        }

        System.out.println(cost[N]);
    }

}
