import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<List<int[]>> edge = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		for (int i=0;i<=n;i++) {
			edge.add(new ArrayList<>());
		}
		for (int i=0;i<p;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edge.get(a).add(new int[] {b,c});
			edge.get(b).add(new int[] {a,c});
			set.add(c);
		}
		
		set = new TreeSet<Integer>(set);
		set.add(((TreeSet<Integer>)set).last()+1);
		
		int[] cost = set.stream().mapToInt(Integer::intValue).toArray();
		
		int s = 0; int e = cost.length;
		int gmin = Integer.MAX_VALUE;
		while (s<e) {
			int m = (s+e)/2;
			// 1 : max, 2 : count
			Queue<int[]> queue = new PriorityQueue<>((a,b)->{
				int c = Integer.compare(a[2], b[2]);
				if (c==0) {
					return Integer.compare(a[1], b[1]);
				} else {
					return -c;
				}
			});
			boolean[] visited = new boolean[n+1];
			queue.add(new int[] {1,0,k,0});
			int min = Integer.MAX_VALUE;
			int cnt = Integer.MAX_VALUE;
			while (!queue.isEmpty()) {
				int[] i = queue.poll();
				int x = i[0];
				if (visited[x]) continue;
				visited[x] = true;
				if (x==n) {
					min = Math.min(min, i[1]);
					cnt = i[2];
					break;
				}
				int max = i[1];
				int count = i[2];
				for (int[] w : edge.get(x)) {
					if (!visited[w[0]]) {
						int t = w[0];
						int c = w[1];
						if (c>=cost[m]) {
							if (count==0) continue;
							queue.add(new int[] {t,max,count-1});
						} else {
							queue.add(new int[] {t,Math.max(max, c),count});
						}
					}
				}
			}
			if (min==Integer.MAX_VALUE) {
				s = m+1;
			} else if (cnt>0) {
				gmin = Math.min(gmin, min);
				e = m;
			} else {
				gmin = Math.min(gmin, min);
				s = m+1;
			}
		}
		if (gmin==Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(gmin);
		}
	}
}
