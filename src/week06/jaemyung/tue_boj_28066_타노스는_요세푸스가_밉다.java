import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class tue_boj_28066_타노스는_요세푸스가_밉다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 청설모의 수
		int K = Integer.parseInt(st.nextToken()); // 제거해야 할 청설모의 수
		
		Deque<Integer> deq = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			deq.addLast(i);
		}
		
		// 덱의 사이즈가 1일때 까지 반복하면서
		while (deq.size() > 1) {
			// 만약 덱의 사이즈가 K보다 크면
			if (deq.size() > K) {
				deq.addLast(deq.pollFirst()); // 첫번째 원소를 빼서 맨 뒤로 넣어준다
				for (int i = 1; i < K; i++) {
					deq.pollFirst(); // K-1개만큼 앞에서부터 제거해준다
				}
				// 사이즈가 k보다 작아진 경우
			} else {
				// 덱의 사이즈가 1이 될때까지 뒤에서부터 청솔모를 제거해준다
				while (deq.size() > 1) {
					deq.pollLast();
				}
			}
		}
		
		bw.write(deq.poll() + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
