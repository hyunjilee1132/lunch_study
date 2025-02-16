package week03.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class thu_boj_11727_2xn타일링2 {
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
			// 11726_2xn 타일링과 다른 부분은 2를 곱하는 부분뿐임
			fibo[i] = (fibo[i-1] + 2*fibo[i-2])%10007;
		}
		last = n;
	}
}