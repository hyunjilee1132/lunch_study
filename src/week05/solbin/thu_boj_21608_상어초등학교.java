import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int[][] sit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		// 입력
		n = Integer.parseInt(br.readLine());
		// 자리에 있는 학생
		sit = new int[n][n];
		
		List<Set<Integer>> favList = new ArrayList<>();
		
		for (int i=0;i<=n*n;i++) {
			favList.add(new HashSet<>());
		}
		
		for (int s=0;s<n*n;s++) {
			st = new StringTokenizer(br.readLine());
			// 학생번호
			int stdNum = Integer.parseInt(st.nextToken());
			Set<Integer> favSet = favList.get(stdNum);
			// 좋아하는 네명의 학생
			for (int i=0;i<4;i++) {
				favSet.add(Integer.parseInt(st.nextToken()));
			}
			
			// 배열을 돌면서 pq에 add함
			int max = Integer.MIN_VALUE;
			int x = -1;
			int y = -1;
			
			// 배열 순회 시작
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					if (sit[i][j]!=0) continue;
					int score = 0;
					for (int k=0;k<4;k++) {
						int xx = i+dx[k];
						int yy = j+dy[k];
						if (!bound(xx,yy)) continue;
						if (favSet.contains(sit[xx][yy])) {
							// 좋아하는 학생수 더하기
							score+=100;
						} else if (sit[xx][yy]==0) {
							// 빈자리 더하기
							score+=1;
						}
					}
					
					// 최적의 자리 위치 저장
					if (score>max) {
						x = i;
						y = j;
						max = score;
					}
				}
			} // 배열순회 종료
			
			// 배열을 돌면서 찾은 최적의 자리에 학생을 배치
			sit[x][y] = stdNum;
		}
		
		int satSum = 0;
		// 만족도 계산
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				int stdNum = sit[i][j];
				Set<Integer> favSet = favList.get(stdNum);
				int sat = 1;
				for (int k=0;k<4;k++) {
					int x = i+dx[k];
					int y=  j+dy[k];
					if (bound(x,y)&&favSet.contains(sit[x][y])) {
						sat*=10;
					}
				}
				satSum+=sat/10;
			}
		}
		System.out.println(satSum);
	}
	
	static boolean bound(int x,int y) {
		return x>=0&&x<n&&y>=0&&y<n;
	}
}
