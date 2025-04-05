import java.util.*;
import java.io.*;
public class BOJ2533 {
	static int N;
	static List<List<Integer>> graph = new ArrayList<>();
	static int[][] dp;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int c = 0; c < N; c++) {
			graph.add(new ArrayList<>());
		}
		dp = new int[N][2];
		visited = new boolean[N];
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		dfs(0);
		System.out.println(Math.min(dp[0][0], dp[0][1]));
	}
	static void dfs(int node) {
		visited[node] = true;
		dp[node][0] = 1;
		List<Integer> edges = graph.get(node);
		for (int i : edges) {
			if (visited[i]) continue;
			dfs(i);
			dp[node][0] += Math.min(dp[i][0], dp[i][1]);
			dp[node][1] += dp[i][0];
		}
	}
}
