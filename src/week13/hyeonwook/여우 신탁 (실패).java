import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static long[] numbers;
	static HashMap<Integer, Long> dp = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new long[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Long.parseLong(st.nextToken());
		}
		for (int i = 0; i < numbers[0]; i++) {
			dp.put(i, 1L);
		}
		for (int idx = 1; idx < N; idx++) {
			HashMap<Integer, Long> new_dp = new HashMap<>();
			for (int k : dp.keySet()) {
				long v = dp.get(k);
				int nk = (int) (k%numbers[idx]);
				if (new_dp.get(nk)==null) {
					new_dp.put(nk, v);
				} else {
					long p = new_dp.get(nk);
					new_dp.put(nk, p+v);
				}
			}
			dp = new_dp;
		}
		long sum = 0;
		for (int i : dp.keySet()) {
			sum += i * dp.get(i);
		}
		double ans = (double) sum / (double) numbers[0];
		System.out.printf("%.10f",ans);
	}
}
