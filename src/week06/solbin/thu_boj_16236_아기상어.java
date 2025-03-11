import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	final static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int X;
	static int Y;
	static int size;
	static int ate;
	static Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
    // 가장 위에 있는 물고기, 그리고 왼쪽에 있는 물고기를 우선하기 위한 Comparator
		@Override
		public int compare(int[] o1, int[] o2) {
			int x1=o1[0];
			int y1=o1[1];
			int t1=o1[2];
			int x2=o2[0];
			int y2=o2[1];
			int t2=o2[2];
			if (t1==t2) {
				if (x1==x2) {
					return y1-y2;
				} else {
					return x1-x2;
				}
			} else {
				return t1-t2;
			}
		}
	});
	static boolean[][] visited;
	

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					X=i;
					Y=j;
					arr[i][j] = 0;
				}
			}
		}

    // 초기 설정
		int time = 0;
		size = 2;
		ate = 0;

    // 더 먹을 수 있는 물고기가 있으면 계속 반복
		while (check()) {
			int min = 0;
      // 물고기 하나 먹었으면 초기화
			queue.add(new int[] {X,Y,0});
			visited = new boolean[n][n];
      // 다음에 먹을 물고기를 탐색함
			innerLoop:
			while (!queue.isEmpty()) {
				int[] param = queue.poll();
				int x = param[0];
				int y = param[1];
				int dist = param[2];
        // 먹을 수 있는 물고기면 먹고 다음 단계를 진행
				if (arr[x][y]!=0&&arr[x][y]<size) {
					ate++;
					arr[x][y] = 0;
          // 사이즈 키우기
					if (ate==size) {
						size++;
						ate=0;
					}
					X = x;
					Y = y;
					min = dist;
					queue.clear();
					break innerLoop;
				}
        // 물고기를 먹지 않았으면 다음 칸 탐색 시작
				for (int i=0;i<4;i++) {
					int xx = x+dx[i];
					int yy = y+dy[i];
					if (bound(xx,yy)&&!visited[xx][yy]) {
						visited[xx][yy] = true;
						queue.add(new int[] {xx,yy,dist+1});
					}
				}
			}
			if (min==0) break;
			time += min;
		}
		sb.append(time);
		
		System.out.println(sb);
	}
	
	static boolean bound(int x, int y) {
		if (x<0||x>=n||y<0||y>=n||size<arr[x][y]) {
			return false;
		} else {
			return true;
		}
	}
	
	static boolean check() {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if (arr[i][j]!=0&&size>arr[i][j])
					return true;
			}
		}
		return false;
	}
}
