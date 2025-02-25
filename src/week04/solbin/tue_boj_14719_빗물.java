import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[]) throws Exception {
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		
		int[] arr = new int[w];
		for (int i=0;i<w;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=1;i<=h;i++) {
			boolean chk = false;
			int tmp = 0;
			for (int j=0;j<w;j++) {
				if (!chk&&arr[j]>=i) {
					chk = true;
				} else if (chk&&arr[j]<i) {
					tmp++;
				} else if (chk&&arr[j]>=i) {
					sum+=tmp;
					tmp = 0;
				}
			}
		}
		System.out.println(sum);
	}
}
