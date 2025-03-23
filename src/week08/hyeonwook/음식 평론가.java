import java.util.*;
import java.io.*;
public class boj1188 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int a = divide(N,M);
		int M_cut = M/a;
		System.out.println(a*(M_cut-1));
	}
	static int divide(int x, int y) {
		if (y == 0) {
			return x;
		} else {
			return divide(y,x%y);
		}
	}
}
