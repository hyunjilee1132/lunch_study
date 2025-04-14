import java.util.*;
import java.io.*;
public class BOJ2243 {
	static int N, x;
	static int[] tree;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		x = (int)Math.pow((int)(Math.sqrt(1000000)+1),2);
		tree = new int[4*x];
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a==1) {
				find_candy(b,1,1000000,1);
			} else {
				int c = Integer.parseInt(st.nextToken());
				if (c==-1) {
					delete(b,1,1,1000000);
				} else {
					insert(b,1,1,1000000,c);
				}
			}
		}
		bw.flush();
		bw.close();		
	}
	static void find_candy(int candy, int left, int right, int idx) throws IOException {
		if (idx >= 4*x) return;
		if (left==right||candy == 0) {
			bw.write(left+"\n");
			tree[idx]-=1;
			return;
		}
		int mid = (left+right)/2;
		if (candy > tree[idx*2]) {
			find_candy(candy-tree[idx*2],mid+1,right,idx*2+1);
		} else {
			find_candy(candy,left,mid,idx*2);
		}
		tree[idx] = tree[idx*2]+tree[idx*2+1];
	}
	static void insert(int val, int idx, int start, int end, int num) {
		if (val < start || val > end) {
			return;
		}
		if (start == end) {
			tree[idx] += num;
			return;
		}
		int mid = (start+end)/2;
		insert(val, idx*2, start, mid, num);
		insert(val, idx*2+1, mid+1, end, num);
		tree[idx] = tree[idx*2]+tree[idx*2+1];
	}
	static void delete(int val, int idx, int start, int end) {
		if (val < start || val > end) {
			return;
		}
		if (start == end) {
			tree[idx] -= 1;
			return;
		}
		int mid = (start+end)/2;
		delete(val, idx*2, start, mid);
		delete(val, idx*2+1, mid+1, end);
		tree[idx] = tree[idx*2]+tree[idx*2+1];
	}
}
