package week03.hyunji;

import java.util.Scanner;

public class wed_boj_11659_구간합구하기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
            arr[i] = arr[i-1] + arr[i];
        } //초기화, 누적합

        for(int i=0; i<m; i++) {
            int from = Integer.parseInt(sc.next());
            int to = Integer.parseInt(sc.next());
            System.out.println(arr[to] - arr[from-1]);
        }
    }
}