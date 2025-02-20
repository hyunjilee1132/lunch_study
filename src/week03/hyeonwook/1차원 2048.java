import java.util.*;
import java.io.*;
public class boj27514_2048 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[63]; // 2의 0승 부터 2의 62승까지 지수 저장
		while(st.hasMoreTokens()) {
			long number = Long.parseLong(st.nextToken());
			if (number != 0) {
				list[(int)(Math.log(number)/Math.log(2))] += 1;
			}
		}
		for (int i = 0; i < 62; i++) {
			int x = list[i];
			list[i+1] += x/2;
		}
		boolean bigger_than_zero = false;
		int pow2 = 0;
		for (int x = 62; x >=0; x--) {
			if (list[x] > 0) {
				bigger_than_zero = true;
				pow2 = x;
				break;
			}
		}
		long answer = 0;
		if (bigger_than_zero) {
			answer = (long)Math.pow(2, pow2);
		}
		System.out.println(answer);
	}
}
