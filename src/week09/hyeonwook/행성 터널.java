package boj;
import java.util.*;
import java.io.*;
class Position{
	int num;
	int pos;
	public Position(int num, int pos) {
		this.num = num;
		this.pos = pos;
	}	
}
class Tunnel implements Comparable<Tunnel>{
	int from;
	int to;
	int val;
	public Tunnel(int from, int to, int val) {
		this.from = from;
		this.to = to;
		this.val = val;
	}
	public int compareTo(Tunnel o) {
		return this.val - o.val;
	}
}
public class boj2887 {
	static int N;
	static Position[] x_list, y_list, z_list;
	static boolean[] visited;
	static PriorityQueue<Tunnel> queue = new PriorityQueue<>();
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		x_list = new Position[N];
		y_list = new Position[N];
		z_list = new Position[N];
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			x_list[i] = new Position(i,x);
			y_list[i] = new Position(i,y);
			z_list[i] = new Position(i,z);
			parent[i] = i;
		}
		Arrays.sort(x_list, new Comparator<Position>(){
			public int compare(Position o1, Position o2) {
				return o1.pos - o2.pos;
			}	
		});
		Arrays.sort(y_list, new Comparator<Position>(){
			public int compare(Position o1, Position o2) {
				return o1.pos - o2.pos;
			}	
		});
		Arrays.sort(z_list, new Comparator<Position>(){
			public int compare(Position o1, Position o2) {
				return o1.pos - o2.pos;
			}	
		});
		for (int i = 0; i < N-1; i++) {
			Tunnel tx = new Tunnel(x_list[i].num, x_list[i+1].num, Math.abs(x_list[i].pos-x_list[i+1].pos));
			Tunnel ty = new Tunnel(y_list[i].num, y_list[i+1].num, Math.abs(y_list[i].pos-y_list[i+1].pos));
			Tunnel tz = new Tunnel(z_list[i].num, z_list[i+1].num, Math.abs(z_list[i].pos-z_list[i+1].pos));
			queue.add(tx);
			queue.add(ty);
			queue.add(tz);
		}
		int cnt = 0;
		int total = 0;
		while (cnt < N-1) {
			Tunnel t = queue.poll();
			int p_from = find(t.from);
			int p_to = find(t.to);
			if(p_from==p_to) continue;
			total += t.val;
			union(p_from, p_to);
			cnt++;
		}
		System.out.println(total);
	}
	static void union(int x, int y) {
		if (parent[x]!=x) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}
	static int find(int idx) {
		if (parent[idx]!=idx) {
			parent[idx] = find(parent[idx]);
		}
		return parent[idx];
	}
}
