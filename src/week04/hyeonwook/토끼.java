import java.util.*;
import java.io.*;
public class boj2943 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = (int)Math.sqrt(n);
		int x = n / k;
		if (n%k!=0) {
			x+=1;
		}
		int[] box = new int[n];
		int[] cup = new int[x];
		for (int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken());
			int a = Integer.parseInt(st2.nextToken());
			int sum = 0;
			int z = a-1;
			while (z <= a+s-2) {
				if (z%k == 0 && (z+k <= a+s-1 || a+s-1 == n)) {
					sum += 1 + cup[z/k];
					cup[z/k] += 1;
					z = z + k;
				} else {
					sum += 1 +box[z];
					box[z] += 1;
					z++;
				}
			}
			bw.write(sum+"\n");
		}
		bw.flush();
		bw.close();
	}
}
