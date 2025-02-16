package week03.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class wed_boj_11726_2xn타일링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static long[] fibo = new long[1001];
	static int last;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		// 단계마다 직접 적어서 보니 피보나치 수열임. 왜 그런지는 모르겠음
		fibo[0] = 1;
		fibo[1] = 1;
		last = 1;
		if (n>last) getFibo(n);
		System.out.println(fibo[n]);
	}
	static void getFibo(int n) {
		for (int i=last+1;i<=n;i++) {
			fibo[i] = (fibo[i-1] + fibo[i-2])%10007;
		}
		last = n;
	}
}