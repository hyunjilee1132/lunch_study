package week02.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class thu_boj_9461_파도반수열2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n+2];
			arr[0] = 1;
			arr[1] = 1;
			arr[2] = 1;
			
			for (int i=3;i<n;i++) {
				arr[i] = arr[i-2]+arr[i-3];
			}
			sb.append(arr[n-1]+"\n");
		}
		System.out.println(sb);
	}
}