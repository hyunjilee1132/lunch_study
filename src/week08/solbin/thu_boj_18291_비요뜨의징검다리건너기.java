import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	final static int p = 1000000007;
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++,sb.append("\n")) {
			int n = Integer.parseInt(br.readLine());
			if (n<=2) {
				sb.append(1);
			} else {
				long mp = 2;
				int len = Integer.numberOfTrailingZeros(Integer.highestOneBit(n-2));
				long res = 1;
				for (int i=0;i<=len;i++,mp=mp*mp%p) {
					if (((n-2)&(1<<i))!=0) {
						res = (res*mp)%p;
					}
				}
				sb.append(res);
			}
		}
		System.out.println(sb);
	}
}
