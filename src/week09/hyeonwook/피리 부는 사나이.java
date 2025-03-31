import java.util.*;
import java.io.*;
public class Main {
	static int N,M;
	static char[] direction;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		direction = new char[N*M];
		parent = new int[N*M];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int k = 0; k < M; k++) {
				direction[idx] = s.charAt(k);
				parent[idx] = idx;
				idx++;
			}
		}
		int cnt = 0;
		for (int x = 0; x < N*M; x++) {
			int z = 0;
			switch(direction[x]) {
			case 'L':
				z = x-1;
				break;
			case 'R':
				z = x+1;
				break;
			case 'U':
				z = x-M;
				break;
			case 'D':
				z = x+M;
				break;
			}
			int a = find(z);
			int b = find(x);
			if (a!=b) {
				union(a,b);
			} else {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static int find(int idx) {
		if (parent[idx]==idx) return idx;
		else {
			return find(parent[idx]);
		}
	}
	static void union(int a, int b) {
		parent[b] = a;
	}
}
