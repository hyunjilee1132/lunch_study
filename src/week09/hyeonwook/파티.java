import java.util.*;
import java.io.*;
class Road implements Comparable<Road>{
	int s;
	int e;
	int c;
	public Road(int s, int e, int c) {
		this.s = s;
		this.e = e;
		this.c = c;
	}
	public int compareTo(Road o) {
		return this.c - o.c;
	}
}
public class BOJ1238 {
	static int N, M, X;
	static List<List<Road>> roads_in = new ArrayList<>();
	static List<List<Road>> roads_out = new ArrayList<>();
	static int[] dist1, dist2;
	static PriorityQueue<Road> queue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		dist1 = new int[N];
		dist2 = new int[N];
		for (int n = 0; n < N; n++) {
			roads_in.add(new ArrayList<>());
			roads_out.add(new ArrayList<>());
		}
		for (int m = 0; m < M; m++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken())-1;
			int e = Integer.parseInt(st2.nextToken())-1;
			int c = Integer.parseInt(st2.nextToken());
			roads_in.get(s).add(new Road(s,e,c));
			roads_out.get(e).add(new Road(e,s,c));
		}
		Arrays.fill(dist1, Integer.MAX_VALUE);
		Arrays.fill(dist2, Integer.MAX_VALUE);
		dist1[X] = 0;
		dist2[X] = 0;
		for (Road road : roads_in.get(X)) {
			queue.add(road);
		}
		dijkstra1();
		queue.clear();
		for (Road road : roads_out.get(X)) {
			queue.add(road);
		}
		dijkstra2();
		int max = 0;
		for (int n = 0; n < N; n++) {
			max = Math.max(max, dist1[n]+dist2[n]);
		}
		System.out.println(max);
	}
	static void dijkstra1() {
		while(!queue.isEmpty()) {
			Road r = queue.poll();
			if (dist1[r.e] > dist1[r.s]+r.c) {
				dist1[r.e] = dist1[r.s]+r.c;
				for (Road road : roads_in.get(r.e)) {
					queue.add(road);
				}
			}
		}
	}
	static void dijkstra2() {
		while(!queue.isEmpty()) {
			Road r = queue.poll();
			if (dist2[r.e] > dist2[r.s]+r.c) {
				dist2[r.e] = dist2[r.s]+r.c;
				for (Road road : roads_out.get(r.e)) {
					queue.add(road);
				}
			}
		}
	}
}
