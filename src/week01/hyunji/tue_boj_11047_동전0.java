package week01.hyunji;

import java.io.IOException;
import java.util.*;

public class tue_boj_11047_동전0 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        for (int i = n-1; i >= 0; i--) {
            coins[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= m && m > 0) {
                cnt += m / coins[i];
                m = m % coins[i];
            }
        }
        System.out.println(cnt);
    }
}