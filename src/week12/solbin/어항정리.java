import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int arr[],n,k,stack[][];
	static Queue<Integer> queue = new ArrayDeque<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		while (!check()) {
			calc();
			cnt++;
		}
		System.out.println(cnt);
	}
	
	static void calc() {
		int[][] tmp = new int[n][];
		// find min;
		int min = Integer.MAX_VALUE;
		for (int i=0;i<n;i++) {
			if (min==arr[i]) {
				queue.add(i);
			} else if (arr[i]<min) {
				min = arr[i];
				queue.clear();
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			arr[queue.poll()]++;
		}
		
		// 어항 쌓기
		int w = 1;
		int h = 1;
		int s = 0;
		tmp[0] = new int[] {arr[0]};
		while (n>=s+w+h) {
			// 1. 배열선언
			for (int i=s+w;i<s+w+h;i++) {
				tmp[i] = new int[w+1];
				tmp[i][0] = arr[i];
			}
			// 2. 배열옯기기
			for (int i=s;i<s+w;i++) {
				for (int j=0;j<h;j++) {
					tmp[s+w+j][s+w-i] = tmp[i][j];
				}
			}
			// 3. 값바꾸기
			int hh = h;
			s = s+w;
			h = w+1;
			w = hh;
		}
		// 남은 어항 선언하기
		for (int i=s+w;i<n;i++) {
			tmp[i] = new int[] {arr[i]};
		}
		
		// 어항 정리하기
		int[][] diff = new int[n][];
		for (int i=s;i<n;i++) {
			diff[i] = new int[tmp[i].length];
		}
		for (int i=s;i<n;i++) {
			for (int j=0;j<tmp[i].length;j++) {
				for (int d=0;d<4;d++) {
					int x = i+dx[d];
					int y = j+dy[d];
					if (x<s||x>=n) continue;
					if (y<0||y>=tmp[x].length) continue;
					int df = tmp[i][j]-tmp[x][y];
					diff[i][j] -= df/5;
				}
			}
		}
		for (int i=s;i<n;i++) {
			for (int j=0;j<tmp[i].length;j++) {
				tmp[i][j] += diff[i][j];
			}
		}
		
		//바닥에 일렬로 놓기
		int pi = s; // x포인터
		int pj = 0; // y포인터
		for (int i=0;i<n;i++) {
			if (tmp[pi].length==pj) {
				pi++;
				pj = 0;
			}
			arr[i] = tmp[pi][pj++];
		}
		
		// 공중 부양 작업
		w = n/4;
		h = 1;
		s = 0;
		stack = new int[w][4];
		for (int i=0;i<n;i++) {
			int val = i/w;
			switch (val) {
			case 0:
				stack[w-i-1][1] = arr[i];
				break;
			case 1:
				stack[i-w][2] = arr[i];
				break;
			case 2:
				stack[3*w-i-1][3] = arr[i];
				break;
			case 3:
				stack[i-3*w][0] = arr[i];
				break;
			}
		}
		
		// 물고기 정리 작업
		diff = new int[w][4];
		for (int i=0;i<w;i++) {
			for (int j=0;j<4;j++) {
				for (int d=0;d<4;d++) {
					int x = i+dx[d];
					int y = j+dy[d];
					if (x<0||x>=w||y<0||y>=4) continue;
					int df = stack[i][j]-stack[x][y];
					diff[i][j] -= df/5;
				}
			}
		}
		
		//바닥에 일렬로 놓기
		int idx = 0;
		for (int i=0;i<w;i++) {
			for (int j=0;j<4;j++,idx++) {
				arr[idx] = stack[i][j] + diff[i][j];
			}
		}
	}
	
	static boolean check() {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=0;i<n;i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		return max-min<=k;
	}
}
