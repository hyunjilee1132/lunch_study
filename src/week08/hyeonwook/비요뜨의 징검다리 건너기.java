import java.io.*;
public class boj18291 {
	static int N;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			if (N==1) {
				bw.write(1+"\n");
			} else {
				bw.write(comb(N-2)+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	static long comb(int idx) {
		long result = 1;
		long n = 2;
		while (idx > 0) {
			if (idx % 2 == 1) {
				result = (result *  n) % mod;
			}
			n = (n * n) % mod;
			idx /= 2;
		}
		return result;
	}
}
