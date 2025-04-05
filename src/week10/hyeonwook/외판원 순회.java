import java.util.*;
import java.io.*;
public class BOJ2098 {
	static int N;
	static int[][] W, graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		graph = new int[1<<N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while(st.hasMoreTokens()) {
				W[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		for (int i = 0; i < 1<<N; i++) {
			Arrays.fill(graph[i], 17000000);
		}
		graph[1<<0][0] = 0;
		for (int i = 1<<0; i < 1<<N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 17000000) continue;
				for (int k = 0; k < N; k++) {
					if ((i&(1<<k))!=0) continue;
					if (W[j][k] == 0) continue;
					graph[i|(1<<k)][k] = Math.min(graph[i|(1<<k)][k], graph[i][j]+W[j][k]);
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int x = 1; x < N; x++) {
			if (W[x][0] == 0) continue;
			ans = Math.min(graph[(1<<N)-1][x]+W[x][0], ans);
		}
		System.out.println(ans);
	}
}
