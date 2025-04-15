import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder sb = new StringBuilder();
	
	static int[] arr;
	static int[][] minSeg;
	static int n;
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		minSeg = new int[(int)(Math.pow(2, Math.ceil((Math.log(n)/Math.log(2)))+1))][2];
		arr = new int[n+1];
		minSeg[0][0] = Integer.MAX_VALUE;
		for (int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		minInit(1,n,1);
		System.out.println(findMax(1,n));
	}
	
	static long findMax(int s,int e) {
		if (s>e) {
			return 0;
		} else if (s==e) {
			return arr[s];
		} else {
			int[] minInfo = minFind(1,n,1,s,e);
			long width = (e-s+1);
			long area = width*minInfo[0];
			long ll = findMax(s,minInfo[1]-1);
			long rr = findMax(minInfo[1]+1,e);
			return Math.max(area, Math.max(ll, rr));
		}
	}
	
	static int[] minInit(int s,int e,int idx) {
		if (s==e) {
			minSeg[idx][0] = arr[s];
			minSeg[idx][1] = s;
			return minSeg[idx];
		} else {
			int mid = (s+e)/2;
			int[] l = minInit(s,mid,idx*2);
			int[] r = minInit(mid+1,e,idx*2+1);
			minSeg[idx] = r[0]<l[0]?r:l;
			return minSeg[idx];
		}
	}
	
	static int[] minFind(int s,int e,int idx,int l,int r) {
		if (s>r||e<l) {
			return minSeg[0];
		} else if (s>=l&&e<=r) {
			return minSeg[idx];
		} else {
			int mid = (s+e)/2;
			int[] ll = minFind(s,mid,idx*2,l,r);
			int[] rr = minFind(mid+1,e,idx*2+1,l,r);
			return rr[0]<ll[0]?rr:ll;
		}
	}
}
