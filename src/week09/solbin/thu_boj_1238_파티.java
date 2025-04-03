import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		List<List<int[]>> goParty = new ArrayList<>();
		List<List<int[]>> goHome = new ArrayList<>();
		int[] minDist = new int[n+1];
		
		for (int i=0;i<=n;i++) {
			goParty.add(new ArrayList<>());
			goHome.add(new ArrayList<>());
		}
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			goHome.get(s).add(new int[] {e,t});
			goParty.get(e).add(new int[] {s,t});
		}
		Queue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		boolean[] visited = new boolean[n+1];
		pq.add(new int[] {x,0});
		while (!pq.isEmpty()) {
			int[] item = pq.poll();
			int p = item[0];
			int c = item[1];
			if (visited[p]) continue;
			visited[p] = true;
			minDist[p] += c;
			for (int[] t : goParty.get(p)) {
				if (!visited[t[0]]) {
					pq.add(new int[] {t[0],c+t[1]});
				}
			}
		}
		visited = new boolean[n+1];
		pq.add(new int[] {x,0});
		int max = 0;
		while (!pq.isEmpty()) {
			int[] item = pq.poll();
			int p = item[0];
			int c = item[1];
			if (visited[p]) continue;
			visited[p] = true;
			max = Math.max(max, minDist[p] + c);
			for (int[] t : goHome.get(p)) {
				if (!visited[t[0]]) {
					pq.add(new int[] {t[0],c+t[1]});
				}
			}
		}
		System.out.println(max);
	}
} 
