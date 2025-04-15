import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n,arr[];
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = n-1;
		long min = Long.MAX_VALUE;
		while (s<e) {
			int l = (2*s+e)/3;
			int r = (s+2*e+1)/3;
			
			long vl = findMax(l);
			long vr = findMax(r);
			
			if (vl>vr) {
				s = l+1;
				min = Math.min(min, vr);
			} else {
				e = r-1;
				min = Math.min(min, vl);
			}
		}
		System.out.println(min);
	}
	
	static long findMax(int x) {
		long max = 0;
		for (int i=0;i<n;i++) {
			max = Math.max(max, (long)arr[i]*Math.abs(i-x));
		}
		return max;
	}
}
