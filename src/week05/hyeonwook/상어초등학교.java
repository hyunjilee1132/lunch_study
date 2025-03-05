import java.util.*;
import java.io.*;
public class boj21608 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n;
	static HashMap<Integer, List<Integer>> map = new HashMap<>();
	static int[][] graph;
	static Queue<Integer> order = new ArrayDeque<>();
	static void select(int order_num) {
		int max_friend = -1;
		int max_empty = -1;
		int max_x = n+1;
		int max_y = n+1;
		List<Integer> friend_list = map.get(order_num);
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				int friend_count = 0;
				int empty_count = 0;
				if (graph[x][y] == 0) {
					for (int k = 0; k < 4; k++) {
						int nx = x+dx[k];
						int ny = y+dy[k];
						if (nx>=0 && nx <n && ny>=0 && ny<n) {
							if (graph[nx][ny] == 0) {
								empty_count++;
							} else if (friend_list.contains(graph[nx][ny])) {
								friend_count++;
							}
						}
					}
					if (max_friend < friend_count) {
						max_friend = friend_count;
						max_empty = empty_count;
						max_x = x;
						max_y = y;
					} else if (max_friend == friend_count) {
						if (max_empty < empty_count) {
							max_empty = empty_count;
							max_x = x;
							max_y = y;
						} else if(max_empty == empty_count) {
							if (x < max_x) {
								max_x = x;
								max_y = y;
							} else if (x == max_x) {
								if (y < max_y) {
									max_y = y;
								}
							}
						}
					}
				}
			}
		}
		graph[max_x][max_y] = order_num;
	}
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int s = (int)Math.pow(n, 2);
		graph = new int[n][n];  
		for (int p = 1; p <= s; p++) {
			map.put(p, new ArrayList<>());
		}
		for (int i = 0; i < s; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			order.add(num);
			List<Integer> list = map.get(num);
			while(st.hasMoreTokens()) {
				int friend = Integer.parseInt(st.nextToken());
				list.add(friend);
			}
			map.put(num,list);
		}
		while(!order.isEmpty()) {
			int search = order.poll();
			select(search);
		}
		int sum = 0;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				int cnt = 0;
				List<Integer> final_friends = map.get(graph[x][y]);
				for (int z = 0; z < 4; z++) {
					int nx = x+dx[z];
					int ny = y+dy[z];
					if (nx>=0 && nx<n && ny>=0 && ny<n) {
						if (final_friends.contains(graph[nx][ny])) {
							cnt++;
						}
					}
				}
				if (cnt != 0) {
					sum += (int) Math.pow(10,cnt-1);
				}
			}
		}
		System.out.println(sum);
	}
}
