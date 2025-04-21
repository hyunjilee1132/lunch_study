import java.util.*;
import java.io.*;
public class BOJ23291 {
	static int N,K;
	static int[][] graph;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<int[]> change = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			graph[N-1][i] = Integer.parseInt(st2.nextToken());
		}
		int time = 0;
		while(true) {
			int diff = Arrays.stream(graph[N-1]).max().getAsInt() - Arrays.stream(graph[N-1]).min().getAsInt();
			if (diff <= K) break;
			fish_control();
			time++;
		}
		System.out.println(time);
	}
	static void fish_control() {
		int min = Arrays.stream(graph[N-1]).min().getAsInt();
		for (int i = 0; i < N; i++) {
			if (graph[N-1][i]==min) {
				graph[N-1][i]++;
			}
		}
		graph[N-2][1] = graph[N-1][0];
		graph[N-1][0] = 0;
		boolean move_finish = false;
		while(true) {
			int a = 0;
			for (int y = N-1; y >=0; y--) {
				if (graph[N-1][y]==0) {
					break;
				}
				if (graph[N-2][y]==0 && graph[N-2][y-1]!=0) {
					a = y;
					int h = 0;
					for (int x = N-1; x >= 0; x--) {
						if (graph[x][y-1]==0) break;
						h++;
					}
					if (a+h-1>=N) {
						move_finish = true;
					}
				}
				if (move_finish) break;
				if (graph[N-2][y]!=0) {
					for (int x = N-1; x >= 0; x--) {
						if (graph[x][y]==0) break;
						graph[N-1-(a-y)][a+N-1-x] = graph[x][y];
						graph[x][y] = 0;
					}
				}
			}
			if (move_finish) break;
			if (graph[N-2][N-1]!=0) break;
		}
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (graph[x][y]==0) continue;
				for (int d = 0; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if (nx<0||ny<0||nx>=N||ny>=N) continue;
					if (graph[nx][ny]==0) continue;
					if (graph[x][y]<graph[nx][ny]+4) continue;
					int dif = (graph[x][y]-graph[nx][ny])/5;
					change.add(new int[]{x,y,nx,ny,dif});
				}
			}
		}
		for (int[] c : change) {
			int x = c[0];
			int y = c[1];
			int nx = c[2];
			int ny = c[3];
			int dif = c[4];
			graph[x][y] -= dif;
			graph[nx][ny] += dif;
		}
		change.clear();
		int a = 0;
		for (int y = 0; y < N; y++) {
			if (graph[N-1][y]==0) continue;
			for (int x = N-1; x >= 0; x--) {
				if (graph[x][y]==0) break;
				change.add(new int[] {a,graph[x][y]});
				graph[x][y] = 0;
				a++;
			}
		}
		for (int[] c : change) {
			graph[N-1][c[0]] = c[1];
		}
		change.clear();
		for (int i = 0; i < N/2; i++) {
			graph[N-2][N-1-i] = graph[N-1][i];
			graph[N-1][i] = 0;
		}
		int f = N-1 + N/2;
		for (int i = N/2; i < 3*N/4; i++) {
			graph[N-4][f-i] = graph[N-1][i];
			graph[N-3][f-i] = graph[N-2][i];
			graph[N-1][i] = 0;
			graph[N-2][i] = 0;
		}
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (graph[x][y]==0) continue;
				for (int d = 0; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if (nx<0||ny<0||nx>=N||ny>=N) continue;
					if (graph[nx][ny]==0) continue;
					if (graph[x][y]<graph[nx][ny]+4) continue;
					int dif = (graph[x][y]-graph[nx][ny])/5;
					change.add(new int[]{x,y,nx,ny,dif});
				}
			}
		}
		for (int[] c : change) {
			int x = c[0];
			int y = c[1];
			int nx = c[2];
			int ny = c[3];
			int dif = c[4];
			graph[x][y] -= dif;
			graph[nx][ny] += dif;
		}
		change.clear();
		a = 0;
		for (int y = 0; y < N; y++) {
			if (graph[N-1][y]==0) continue;
			for (int x = N-1; x >= 0; x--) {
				if (graph[x][y]==0) break;
				change.add(new int[] {a,graph[x][y]});
				graph[x][y] = 0;
				a++;
			}
		}
		for (int[] c : change) {
			graph[N-1][c[0]] = c[1];
		}
		change.clear();
	}
}
