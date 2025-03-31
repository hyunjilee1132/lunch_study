import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[][] arr;
	static int[][] num;
	static List<Set<Integer>> set;
	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		num = new int[n][m];
		set = new ArrayList<>();
		for (int i=0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		// cnt는 묶음의 갯수를 셈
		int cnt = 0;
		// sum은 안전구역의 갯수를 셈
		int sum = 0;
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				// X는 방문한곳
				if (arr[i][j]!='X') {
					// dfs를 돌면서 끝에서 만난 구역의 번호를 가져옴
					int res = dfs(i,j,++cnt);
					// 자기자신을 가져왔으면 새로운 구역이 만들어졌으므로 안전구역의 갯수를 더함
					if (res==cnt) sum++;
				}
			}
		}
		sb.append(sum);
		
		System.out.println(sb);
	}
	
	static int dfs(int x,int y,int g) {
		char c = arr[x][y];
		arr[x][y] = 'X';
		// g는 구역번호
		int gg = g;
		switch (c) {
		case 'L':
			if (arr[x][y-1]!='X') {
				gg = dfs(x,y-1,g);
			} else {
				if (num[x][y-1] == 0) {
					gg = g;
				} else {
					gg = num[x][y-1]; 
				}
			}
			break;
		case 'R':
			if (arr[x][y+1]!='X') {
				gg = dfs(x,y+1,g);
			} else {
				if (num[x][y+1] == 0) {
					gg = g;
				} else {
					gg = num[x][y+1]; 
				}
			}
			break;
		case 'U':
			if (arr[x-1][y]!='X') {
				gg = dfs(x-1,y,g);
			} else {
				if (num[x-1][y] == 0) {
					gg = g;
				} else {
					gg = num[x-1][y]; 
				}
			}
			break;
		case 'D':
			if (arr[x+1][y]!='X') {
				gg = dfs(x+1,y,g);
			} else {
				if (num[x+1][y] == 0) {
					gg = g;
				} else {
					gg = num[x+1][y]; 
				}
			}
			break;
		}
		num[x][y] = gg;
		// 구역의 번호를 리턴함
		return gg;
	}
}
