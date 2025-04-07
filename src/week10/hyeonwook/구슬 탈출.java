import java.util.*;
import java.io.*;
class Board {
	int move;
	int rx;
	int ry;
	int bx;
	int by;
	char[][] graph;
	public Board(int move, int rx, int ry, int bx, int by, char[][] graph) {
		this.move = move;
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.graph = graph;
	}
}
public class BOJ13460 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,M, rx, ry, bx, by, ans;
	static char[][] graph;
	static Queue<Board> queue = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		for (int k = 0; k < N; k++) {
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				graph[k][i] = s.charAt(i);
				if (graph[k][i] == 'R') {
					rx = k;
					ry = i;
				} else if (graph[k][i] == 'B') {
					bx = k;
					by = i;
				}
			}
		}
		queue.add(new Board(0,rx,ry,bx,by,graph));
		ans = -1;
		bfs();
		System.out.println(ans);
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			boolean success = false;
			boolean fail = false;
			Board b = queue.poll();
			if (b.move==10) break;
			for (int i = 0; i < 4; i++) {
				boolean moved = false;
				int rx = b.rx;
				int ry = b.ry;
				int bx = b.bx;
				int by = b.by;
				success = false;
				fail = false;
				char[][] new_graph = new char[N][M];
				for (int j = 0; j < N; j++) {
					new_graph[j]=Arrays.copyOf(b.graph[j], M);
				}
				while(true){
					int nrx = rx+dx[i];
					int nry = ry+dy[i];
					if (new_graph[nrx][nry]!='.'&&new_graph[nrx][nry]!='O') break;
					moved = true;
					if (new_graph[nrx][nry]=='.') {
						new_graph[rx][ry] = '.';
						new_graph[nrx][nry] = 'R';
						rx = nrx;
						ry = nry;
					} else if (new_graph[nrx][nry]=='O') {
						new_graph[rx][ry] = '.';
						success = true;
						break;
					}
				}
				while(true) {
					int nbx = bx+dx[i];
					int nby = by+dy[i];
					if (new_graph[nbx][nby]!='.'&&new_graph[nbx][nby]!='O') break;
					moved = true;
					if (new_graph[nbx][nby]=='.') {
						new_graph[bx][by] = '.';
						new_graph[nbx][nby] = 'B';
						bx = nbx;
						by = nby;
					} else if (new_graph[nbx][nby]=='O') {
						fail = true;
						break;
					}
				}
				if (fail) {
					continue;
				} else if (!fail&&success) {
					break;
				}
				while(true){
					int nx = rx+dx[i];
					int ny = ry+dy[i];
					if (new_graph[nx][ny]!='.'&&new_graph[nx][ny]!='O') break;
					moved = true;
					if (new_graph[nx][ny]=='.') {
						new_graph[rx][ry] = '.';
						new_graph[nx][ny] = 'R';
						rx = nx;
						ry = ny;
					}
				}
				if (moved) {
					queue.add(new Board(b.move+1,rx,ry,bx,by,new_graph));
				}
			}
			if (!fail&&success) {
				ans = b.move+1;
				break;
			}
		}
	}
}
