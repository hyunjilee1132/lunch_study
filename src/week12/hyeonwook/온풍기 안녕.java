import java.util.*;
import java.io.*;
public class BOJ23289 {
	static int R,C,K,W,chocolate;
	static int[][] graph, real_graph, prev_graph;
	static List<int[]> up_heater = new ArrayList<>();
	static List<int[]> down_heater = new ArrayList<>();
	static List<int[]> left_heater = new ArrayList<>();
	static List<int[]> right_heater = new ArrayList<>();
	static List<int[]> checks = new ArrayList<>();
	static List<int[]> xychanges = new ArrayList<>();
	static Queue<int[]> queue = new ArrayDeque<>();
	static boolean[][][] walls;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st1.nextToken());
		C = Integer.parseInt(st1.nextToken());
		K = Integer.parseInt(st1.nextToken());
		graph = new int[R][C];
		real_graph = new int[R][C];
		prev_graph = new int[R][C];
		walls = new boolean[R][C][2];
		for (int i = 0; i < R; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st2.nextToken());
				graph[i][j] = num;
				if (num == 0) continue;
				switch(num) {
				case 1:
					right_heater.add(new int[] {i,j});
					break;
				case 2:
					left_heater.add(new int[] {i,j});
					break;
				case 3:
					up_heater.add(new int[] {i,j});
					break;
				case 4:
					down_heater.add(new int[] {i,j});
					break;
				case 5:
					checks.add(new int[] {i,j});
					break;
				}
			}
		}
		W = Integer.parseInt(br.readLine());
		for (int w = 0; w < W; w++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st3.nextToken())-1;
			int y = Integer.parseInt(st3.nextToken())-1;
			int t = Integer.parseInt(st3.nextToken());
			walls[x][y][t] = true;
		}
		chocolate = 0;
		while(true) {
			for (int[] u : up_heater) {
				int x = u[0];
				int y = u[1];
				queue.add(new int[] {x-1,y,1,5});
				simulation();
			}
			for (int[] d : down_heater) {
				int x = d[0];
				int y = d[1];
				queue.add(new int[] {x+1,y,2,5});
				simulation();
			}
			for (int[] l : left_heater) {
				int x = l[0];
				int y = l[1];
				queue.add(new int[] {x,y-1,3,5});
				simulation();
			}
			for (int[] r : right_heater) {
				int x = r[0];
				int y = r[1];
				queue.add(new int[] {x,y+1,4,5});
				simulation();
			}
			temp_control();
			xychanges.clear();
			for (int y = 0; y < C; y++) {
				if (real_graph[0][y]>=1) {
					real_graph[0][y]--;
				}
				if (real_graph[R-1][y]>=1) {
					real_graph[R-1][y]--;
				}
			}
			for (int x = 1; x < R-1; x++) {
				if (real_graph[x][0]>=1) {
					real_graph[x][0]--;
				}
				if (real_graph[x][C-1]>=1) {
					real_graph[x][C-1]--;
				}
			}
			chocolate++;
			boolean finish = true;
			for (int[] check : checks) {
				if (real_graph[check[0]][check[1]]<K) {
					finish = false;
					break;
				}
			}
			if (finish || chocolate > 100) break;
		}
		if (chocolate > 100) {
			System.out.println(101);
		} else {
			System.out.println(chocolate);
		}
	}
	static void simulation() {
		boolean[][] visited = new boolean[R][C];
		while(!queue.isEmpty()) {
			int[] change = queue.poll();
			int x = change[0];
			int y = change[1];
			int d = change[2];
			int a = change[3];
			if (x>=0&&y>=0&&x<R&&y<C&&!visited[x][y]) {
				real_graph[x][y]+=a;
				visited[x][y] = true;
			}
			if (a==1) continue;
			boolean first = true;
			boolean second = true;
			boolean third = true;
			switch(d) {
			case 1:
				if (walls[x][y][0]) {
					first = false;
				}
				if (y-1>=0&&walls[x][y-1][0]) {
					second = false;
				}
				if (y+1<C&&walls[x][y+1][0]) {
					third = false;
				}
				if (y-1>=0&&walls[x][y-1][1]) {
					second = false;
				}
				if (walls[x][y][1]) {
					third = false;
				}
				if (first&&x-1>=0) {
					queue.add(new int[] {x-1,y,d,a-1});
				}
				if (second&&x-1>=0&&y-1>=0) {
					queue.add(new int[] {x-1,y-1,d,a-1});
				}
				if (third&&x-1>=0&&y+1<C) {
					queue.add(new int[] {x-1,y+1,d,a-1});
				}
				break;
			case 2:
				if (x+1<R&&walls[x+1][y][0]) {
					first = false;
				}
				if (x+1<R&&y-1>=0&&walls[x+1][y-1][0]) {
					second = false;
				}
				if (x+1<R&&y+1<C&&walls[x+1][y+1][0]) {
					third = false;
				}
				if (y-1>=0&&walls[x][y-1][1]) {
					second = false;
				}
				if (walls[x][y][1]) {
					third = false;
				}
				if (first&&x+1<R) {
					queue.add(new int[] {x+1,y,d,a-1});
				}
				if (second&&x+1<R&&y-1>=0) {
					queue.add(new int[] {x+1,y-1,d,a-1});
				}
				if (third&&x+1<R&&y+1<C) {
					queue.add(new int[] {x+1,y+1,d,a-1});
				}
				break;
			case 3:
				if (walls[x][y][0]) {
					second = false;
				}
				if (x+1<R&&walls[x+1][y][0]) {
					third = false;
				}
				if (y-1>=0&&walls[x][y-1][1]) {
					first = false;
				}
				if (x-1>=0&&y-1>=0&&walls[x-1][y-1][1]) {
					second = false;
				}
				if (x+1<R&&y-1>=0&&walls[x+1][y-1][1]) {
					third = false;
				}
				if (first&&y-1>=0) {
					queue.add(new int[] {x,y-1,d,a-1});
				}
				if (second&&x-1>=0&&y-1>=0) {
					queue.add(new int[] {x-1,y-1,d,a-1});
				}
				if (third&&x+1<R&&y-1>=0) {
					queue.add(new int[] {x+1,y-1,d,a-1});
				}
				break;
			case 4:
				if (walls[x][y][0]) {
					second = false;
				}
				if (x+1<R&&walls[x+1][y][0]) {
					third = false;
				}
				if (walls[x][y][1]) {
					first = false;
				}
				if (x-1>=0&&walls[x-1][y][1]) {
					second = false;
				}
				if (x+1<R&&walls[x+1][y][1]) {
					third = false;
				}
				if (first&&y+1<C) {
					queue.add(new int[] {x,y+1,d,a-1});
				}
				if (second&&x-1>=0&&y+1<C) {
					queue.add(new int[] {x-1,y+1,d,a-1});
				}
				if (third&&x+1<R&&y+1<C) {
					queue.add(new int[] {x+1,y+1,d,a-1});
				}
				break;
			}
		}
	}
	static void temp_control() {
		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {
				for (int d = 0; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if (nx<0||ny<0||nx>=R||ny>=C) continue;
					if (real_graph[x][y] <= real_graph[nx][ny]) continue;
					int c = (real_graph[x][y]-real_graph[nx][ny])/4;
					boolean move = true;
					switch(d) {
					case 0:
						if (walls[x][y][0]) {
							move = false;
						}
						break;
					case 1:
						if (x+1<R&&walls[x+1][y][0]) {
							move = false;
						}
						break;
					case 2:
						if (y-1>=0&&walls[x][y-1][1]) {
							move = false;
						}
						break;
					case 3:
						if (walls[x][y][1]) {
							move = false;
						}
						break;
					}
					if (move) {
						xychanges.add(new int[] {x,y,nx,ny,c});
					}
				}
			}
		}
		for (int[] c : xychanges) {
			int x = c[0];
			int y = c[1];
			int nx = c[2];
			int ny = c[3];
			int change = c[4];
			real_graph[x][y] -= change;
			real_graph[nx][ny] += change;
		}
	}
}
