package week1;

import java.util.Scanner;

public class tue_boj_11047_동전0 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int money = sc.nextInt();
		int ans = 0;
		
		int[] coins = new int[size];
		
		for (int i = 0; i < size; i++) {
			coins[i] = sc.nextInt();
		}
		
		for (int i = size-1; i >= 0; i--) {
			// 제일 큰 화폐부터 사용
			ans += money/coins[i];
			money %= coins[i];
		}
		
		System.out.println(ans);
		
	}
}
