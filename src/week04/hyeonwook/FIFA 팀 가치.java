import java.util.*;
import java.io.*;
public class boj29160 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		int[][] pval = new int[12][100001];
		int[] max = new int[12];
		for (int x = 0; x < n; x++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int position = Integer.parseInt(st2.nextToken());
			int value = Integer.parseInt(st2.nextToken());
			pval[position][value] += 1;
			if (value > max[position]) {
				max[position] = value;
			}
		}
		for (int x = 1; x <= k; x++) {
			for (int y = 1; y <= 11; y++) {
				if (max[y] != 0) {
					pval[y][max[y]] -= 1;
					pval[y][max[y]-1] += 1;
					if (pval[y][max[y]] == 0) {
						max[y] -= 1;
					}
				}
			}
		}
		System.out.println(Arrays.stream(max).sum());
	}
}
