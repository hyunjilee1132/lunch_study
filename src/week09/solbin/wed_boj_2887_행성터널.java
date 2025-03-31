import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] parent;
	static int[][] xx;
	static int[][] yy;
	static int[][] zz;
	static Comparator<int[]> order = new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			if (a[0]<b[0]) {
				return -1;
			} else {
				return 1;
			}
		}
	};
	static int[][] edge;

	public static void main(String args[]) throws Exception {
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		xx = new int[n][2];
		yy = new int[n][2];
		zz = new int[n][2];
		parent = new int[n+1];
		
		// 간선은 (n-1)*3개만 저장하면 됨
		edge = new int[(n-1)*3][3];
		int size = 0;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			xx[i][0] = Integer.parseInt(st.nextToken());
			xx[i][1] = i+1;
			yy[i][0] = Integer.parseInt(st.nextToken());
			yy[i][1] = i+1;
			zz[i][0] = Integer.parseInt(st.nextToken());
			zz[i][1] = i+1;
		}
		
		// x좌표 배열, y좌표 배열, z좌표 배열을 각각 정렬함
		Arrays.sort(xx,order);
		Arrays.sort(yy,order);
		Arrays.sort(zz,order);
		
		// x좌표 배열, y좌표 배열, z좌표 배열을 순회하면서 간선을 추가함
		for (int i=1;i<n;i++) {
			edge[size][0] = xx[i][0]-xx[i-1][0];
			edge[size][1] = xx[i-1][1];
			edge[size++][2] = xx[i][1];
			edge[size][0] = yy[i][0]-yy[i-1][0];
			edge[size][1] = yy[i-1][1];
			edge[size++][2] = yy[i][1];
			edge[size][0] = zz[i][0]-zz[i-1][0];
			edge[size][1] = zz[i-1][1];
			edge[size++][2] = zz[i][1];
		}
		
		// 간선 길이순으로 정렬함
		Arrays.sort(edge,order);
		
		int cnt = 0;
		long sum = 0;
		for (int i=0;i<size;i++) {
			int[] item = edge[i];
			int c = item[0];
			int s = item[1];
			int e = item[2];
			int sp = find(s);
			int ep = find(e);
			if (sp==0&&ep==0) {
				parent[e] = s;
				parent[s] = s;
			} else if (sp!=0&&ep==0) {
				parent[e] = sp;
			} else if (sp==0&&ep!=0) {
				parent[s] = ep;
			} else {
				if (sp==ep) {
					continue;
				} else {
					parent[sp] = ep;
				}
			}
			sum+=c;
			if (++cnt==n-1) break;
		}
		sb.append(sum);
		System.out.println(sb);
	}
	
	static int find(int x) {
		int p = parent[x];
		if (p==0) return 0;
		else if (x==p) return x;
		int pp = find(p);
		parent[x] = pp;
		return pp;
	}
}
