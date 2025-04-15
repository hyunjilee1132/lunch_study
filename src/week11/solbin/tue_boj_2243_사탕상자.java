import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	final static int size = 1000000;
	static int[] seg = new int[(int)Integer.highestOneBit(size)<<2];
	public static void main(String args[]) throws Exception {
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch (a) {
			case 1:
				int s = 1;
				int e = size;
				while (s<e) {
					int m = (s+e)/2;
					int r = find(1,size,1,s,m);
					if (r>=b) {
						e = m;
					} else {
						s = m+1;
						b -= r;
					}
				}
				System.out.println(e);
				replace(1,size,1,e,-1);
				break;
			case 2:
				int c = Integer.parseInt(st.nextToken());
				replace(1,size,1,b,c);
				break;
			}
		}
	}
	
	static int replace(int s,int e,int idx,int x,int val) {
		if (s>x||e<x) {
			return seg[idx];
		} else if (s==x&&e==x) {
			return seg[idx]+=val;
		} else {
			int m = (s+e)/2;
			int l = replace(s,m,idx*2,x,val);
			int r = replace(m+1,e,idx*2+1,x,val);
			return seg[idx] = l+r;
		}
	}
	
	static int find(int s,int e,int idx,int l,int r) {
		if (e<l||s>r) {
			return 0;
		} else if (s>=l&&e<=r) {
			return seg[idx];
		} else {
			int m = (s+e)/2;
			int ll = find(s,m,idx*2,l,r);
			int rr = find(m+1,e,idx*2+1,l,r);
			return ll+rr;
		}
	}
}
