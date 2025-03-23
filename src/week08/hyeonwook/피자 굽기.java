import java.util.*;
import java.io.*;
public class boj1756 {
	static int[] widths;
	static int D,N;
	static HashMap<Integer,List<Integer>> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st1.nextToken());
		N = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		widths = new int[D+1];
		widths[0] = Integer.MAX_VALUE;
		int i = 1;
		while(st2.hasMoreTokens()) {
			int width = Integer.parseInt(st2.nextToken());
			widths[i] = Math.min(widths[i-1], width);
			i++;
		}
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int high = widths.length;
		int answer = 0;
		while(st3.hasMoreTokens()) {
			int pizza = Integer.parseInt(st3.nextToken());
			int idx = binarysearch(0,high,pizza);
			if (idx <= 0) {
				answer = 0;
				break;
			}
			high = idx;
			answer = idx;
		}
		System.out.println(answer);
	}
	static int binarysearch(int low, int high, int pizza) {
		if (high <= low) {
			return high-1;
		}
		int mid = (low + high) / 2;
		if (widths[mid] >= pizza) {
			return binarysearch(mid+1, high, pizza);
		} else {
			return binarysearch(low,mid,pizza);
		}
	}
}
