import java.util.*;
import java.io.*;
public class boj28353 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] weights = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int j = 0;
		while(st2.hasMoreTokens()) {
			weights[j] = Integer.parseInt(st2.nextToken());
			j++;
		}
		Arrays.sort(weights);
		int cnt = 0;
		int l = 0;
		int r = n-1;
		while (l<r) {
			int a = weights[l];
			int b = weights[r];
			if (a+b<=k) {
				cnt++;
				l++;
				r--;
			} else {
				r--;
			}
		}
		System.out.println(cnt);
	}
}
