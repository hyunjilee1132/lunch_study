import java.util.*;
import java.io.*;
public class boj16236 {
	static boolean finish = false;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int size,cnt,time,start_x,start_y,n;
	static int[][] graph;
	static Queue<int[]> queue = new LinkedList<>();
	static void bfs() {
		int[][] visited = new int[n][n];
		int[] start = queue.peek();
		visited[start[0]][start[1]] = 1;
		boolean eat = false;
		int final_x = 0;
		int final_y = 0;
		int dist = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int[] s = queue.poll();
			if (s[2]>dist) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = s[0]+dx[i];
				int ny = s[1]+dy[i];
				if (nx>=0&&nx<n&&ny>=0&&ny<n&&visited[nx][ny]==0&&graph[nx][ny]<=size) {
					visited[nx][ny]=1;
					if (graph[nx][ny] == size || graph[nx][ny] == 0) {
						int[] go = {nx,ny,s[2]+1};
						queue.add(go);
					}
					else if (graph[nx][ny]!=0 && graph[nx][ny]<size) {
						eat = true;
						if (dist > s[2]+1) {
							dist = s[2]+1;
							final_x = nx;
							final_y = ny;
						} else if (dist == s[2]+1) {
							if (final_x>nx) {
								final_x = nx;
								final_y = ny;
							} else if (final_x==nx) {
								if (final_y>ny) {
									final_y = ny;
								}
							}
						}
					}
				}
			}
		}
		if (!eat) {
			finish = true;
		}
		else {
			graph[start_x][start_y] = 0;
			start_x = final_x;
			start_y = final_y;
			graph[final_x][final_y] = 9;
			time += dist;
			cnt++;
			if (size == cnt) {
				cnt = 0;
				size++;
			}
		}
	}
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		start_x = 0;
		start_y = 0;
		graph = new int[n][n];
		for (int x = 0; x < n; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int y = 0; y < n; y++) {
				int s = Integer.parseInt(st.nextToken());
				if (s == 9) {
					start_x=x;
					start_y=y;
				}
				graph[x][y] = s;
			}
		}
		size = 2;
		cnt = 0;
		time = 0;
		while (!finish) {
			int[] startxy = {start_x, start_y,0};
			queue.add(startxy);
			bfs();
			queue.clear();
		}
		System.out.println(time);
	}
}
