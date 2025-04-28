import java.io.*;
import java.util.*;
class Edge implements Comparable<Edge> {
	int from;
	int to;
	int val;
	public Edge(int from, int to, int val) {
		this.from = from;
		this.to = to;
		this.val = val;
	}
	public int compareTo(Edge o) {
		return this.val-o.val;
	}	
}
public class BOJ1800{
	static int[][] dist;
	static int N, P, K;
	static List<List<Edge>> edgelist = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		P = Integer.parseInt(st1.nextToken());
		K = Integer.parseInt(st1.nextToken());
		dist = new int[N][K+1];
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				Arrays.fill(dist[i], 0);
			} else {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
		}
		for (int i = 0; i < N; i++) {
			edgelist.add(new ArrayList<>());
		}
		for (int i = 0; i < P; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken())-1;
			int b = Integer.parseInt(st2.nextToken())-1;
			int v = Integer.parseInt(st2.nextToken());
			edgelist.get(a).add(new Edge(a,b,v));
			edgelist.get(b).add(new Edge(b,a,v));
		}
		List<Edge> start = edgelist.get(0);
		for (Edge e : start) {
			pq.add(e);
		}
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int from = e.from;
			int to = e.to;
			int val = e.val;
			int idx = 0;
			int to_idx = 0;
			boolean val_used = false;
			boolean changed = false;
			while (idx <= K && to_idx <= K) {
				if (dist[from][idx]==Integer.MAX_VALUE) break;
				if (!val_used) {
					if (dist[from][idx] < val) {
						val_used = true;
						if (dist[to][to_idx] > val) {
							dist[to][to_idx] = val;
							changed = true;
						}
					} else {
						if (dist[to][to_idx] > dist[from][idx]) {
							dist[to][to_idx] = dist[from][idx];
							changed = true;
						}
						idx++;
					}
				} else {
					if (dist[to][to_idx] > dist[from][idx]) {
						dist[to][to_idx] = dist[from][idx];
						changed = true;
					}
					idx++;
				}
				to_idx++;
			}
			if (changed) {
				for (Edge edge : edgelist.get(to)) {
					pq.add(edge);
				}
			}
		}
		if (dist[N-1][0] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Arrays.stream(dist[N-1]).min().getAsInt());
		}
	}
}
