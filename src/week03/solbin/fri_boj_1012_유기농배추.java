package week03.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class fri_boj_1012_유기농배추 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static boolean[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.valueOf(br.readLine());
		for (int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			arr = new boolean[m][n];
			int k = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			// 배열 데이터 받아오기
			for (int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = true;
			}
			
			for (int i=0;i<m;i++) {
				for (int j=0;j<n;j++) {
					if (arr[i][j]) {
						// DFS로 구역의 갯수를 카운트
						cnt++;
						check(i,j);
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
	
	// DFS로 구역의 갯수를 카운트
	static void check(int x,int y) {
		if (x<0||x>=m||y<0||y>=n||!arr[x][y]) {
			return;
		} else {
			arr[x][y]=false;
			check(x-1,y);
			check(x+1,y);
			check(x,y-1);
			check(x,y+1);
		}
	}
}