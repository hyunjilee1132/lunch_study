package week02.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class fri_boj_11659_구간합구하기4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] sum= new int[n+1];
		st = new StringTokenizer(br.readLine());
		
		// 처음부터 그 수까지의 합을 배열에 저장해놓음
		sum[1] = Integer.parseInt(st.nextToken());
		for (int i=2;i<n+1;i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// j까지의 합에 i-1까지의 합을 뺀다.
		for (int a=0;a<m;a++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(sum[j]-sum[i-1]+"\n");
		}
		
		System.out.println(sb);
	}
}