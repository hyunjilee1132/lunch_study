import java.util.*;
import java.io.*;
public class boj28066 {
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		int k = Integer.parseInt(st.nextToken());
		while (true) {
			if (queue.size() <= k) {
				System.out.println(queue.poll());
				break;
			}
			else {
				int c = queue.poll();
				queue.add(c);
				for (int i = 1; i < k; i++) {
					queue.poll();
				}
			}
		}
	}
}
