import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static char[][] arr;
	
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	static int[][][][] map;
	
	static int bx = -1, by = -1, rx = -1, ry = -1;
	static int min;
	
	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		map = new int[n][m][4][2];
		for (int i=0;i<n;i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0;j<m;j++) {
				if (input[j]=='B') {
					bx = i;
					by = j;
					arr[i][j] = '.';
				} else if (input[j]=='R') {
					rx = i;
					ry = j;
					arr[i][j] = '.';
				} else {
					arr[i][j] = input[j];
				}
			}
		}
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				for (int d=0;d<4;d++) {
					int x = i;
					int y = j;
					while (bound(x+=dx[d],y+=dy[d])) {
						if (arr[x-dx[d]][y-dy[d]]=='O') break;
					}
					map[i][j][d][0] = x-dx[d];
					map[i][j][d][1] = y-dy[d];
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		back(1);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	
	static void back(int cnt) {
		if (cnt==11) return;
		int abx=bx;
		int aby=by;
		int arx=rx;
		int ary=ry;
		int a;
		for (int d=0;d<4;d++) {
			bx=map[abx][aby][d][0];
			by=map[abx][aby][d][1];
			rx=map[arx][ary][d][0];
			ry=map[arx][ary][d][1];
			
			if (arr[rx][ry]=='O') {
				if (arr[bx][by]=='O') continue;
				min = Math.min(cnt, min);
				return;
			}
			
			if (bx==rx&&by==ry) {
				switch(d) {
				case 0:
					a = abx<arx?rx++:bx++;
					break;
				case 1:
					a = abx<arx?bx--:rx--;
					break;
				case 2:
					a = aby<ary?ry++:by++;
					break;
				case 3:
					a = aby<ary?by--:ry--;
					break;
				}
			}
			if (bx==abx&&by==aby&&rx==arx&&ry==ary) {
				continue;
			}
			back(cnt+1);
		}
	}
	
	static boolean bound(int x,int y) {
		return x>=0&&x<n&&y>=0&&y<m&&arr[x][y]!='#';
	}
}
