import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<List<Integer>> edge = new ArrayList<>();;
	
	static boolean[] visited;
	
	public static void main(String args[]) throws Exception {
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		for (int i=0;i<=n;i++) {
			edge.add(new ArrayList<>());
		}
		for (int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			edge.get(s).add(e);
			edge.get(e).add(s);
		}
		visited[1] = true;
		int[] ret = dfs(1);
		
		System.out.println(Math.min(ret[0], ret[1]));
	}
	
	static int[] dfs(int x) {
		int t = 1;
		int f = 0;
		for (int c : edge.get(x)) {
			if (!visited[c]) {
				visited[c] = true;
				int[] item = dfs(c);
				t += Math.min(item[0], item[1]);
				f += item[0];
			}
		}
		return new int[] {t,f};
	}
}
