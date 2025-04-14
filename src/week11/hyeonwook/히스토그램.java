import java.util.*;
import java.io.*;
public class BOJ1725 {
	static int N, max;
	static Stack<int[]> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = 0;
		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(br.readLine());
			if (stack.isEmpty()) {
				stack.add(new int[] {i,h});
			} else {
				while(!stack.isEmpty()) {
					int[] t = stack.peek();
					if (t[1] <= h) {
						stack.add(new int[] {i,h});
						break;
					} else {
						stack.pop();
						if (stack.isEmpty()) {
							max = Math.max(t[1]*(i-1), max);
						} else {	
							int[] p = stack.peek();
							max = Math.max(t[1]*(i-p[0]-1), max);
						}
					}
				}
				if (stack.isEmpty()) {
					stack.add(new int[] {i,h});
				}
			}
		}
		int[] t = stack.peek();
		int tidx = t[0];
		while(!stack.isEmpty()) {
			int[] k = stack.pop();
			if (stack.isEmpty()) {
				max = Math.max(k[1]*(tidx), max);
			} else {
				int[] p = stack.peek();
				max = Math.max(k[1]*(tidx-p[0]), max);
			}
		}
		System.out.println(max);
	}
}
