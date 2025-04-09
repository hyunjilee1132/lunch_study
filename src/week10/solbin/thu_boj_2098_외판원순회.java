import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] arr, dp;
	static int all;
	public static void main(String args[]) throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][1<<n];
		all = (1<<n)-1;
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,1);
		System.out.println(dp[0][1]);
	}
	
	static void dfs(int x,int visited) {
		int min = Integer.MAX_VALUE;
		if (visited == all) {
			dp[x][visited] = arr[x][0]==0?Integer.MAX_VALUE:arr[x][0];
			return;
		}
		for (int i=1;i<n;i++) {
			if ((visited&(1<<i))!=0||arr[x][i]==0) continue;
			if (dp[i][visited|(1<<i)]==0) {
				dfs(i,visited|(1<<i));
			}
			min = (int) Math.min(min, (long)arr[x][i]+dp[i][visited|(1<<i)]);
		}
		dp[x][visited] = min;
	}
}
