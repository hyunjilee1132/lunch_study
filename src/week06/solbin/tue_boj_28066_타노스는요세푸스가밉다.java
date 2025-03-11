import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i=1;i<=n;i++) {
			queue.add(i);
		}
		
		while (queue.size()>k) {
			queue.add(queue.poll());
			for (int i=1;i<k;i++) {
				queue.poll();
			}
		}
		System.out.println(queue.poll());
	}
}
