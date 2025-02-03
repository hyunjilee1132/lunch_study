package week1;

import java.util.Scanner;

public class thu_boj_1003_피보나치함수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		long[] zeroCnts =  new long[41];
		long[] oneCnts = new long[41];
		
		zeroCnts[0] = 1;
		oneCnts[1] = 1;
		
		for (int i = 2; i < 41; i++) {
			zeroCnts[i] = zeroCnts[i-1] + zeroCnts[i-2];
			oneCnts[i] = oneCnts[i-1] + oneCnts[i-2];
		}
		
		for (int i = 0; i < tc; i++) {
			int target =sc.nextInt();
			System.out.printf("%d %d\n",zeroCnts[target], oneCnts[target]);
		}
	}
}
