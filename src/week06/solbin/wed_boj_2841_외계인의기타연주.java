import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		// 한 라인을 스택 배열로 관리함
		Stack<Integer>[] line = new Stack[7];
		
		// 배열에 스택을 추가함
		for (int i=1;i<=6;i++) {
			line[i] = new Stack<Integer>();
		}
		
		int cnt = 0;
		// 입력을 받아 처리함
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());
			Stack<Integer> stack = line[idx];
			
			// 스택에서 입력보다 큰 손가락을 제거함
			while (!stack.isEmpty()&&stack.peek()>fret) {
				stack.pop();
				cnt++;
			}
			if (stack.isEmpty()||stack.peek()<fret) {
				// 스택이 비어있거나 마지막 손가락이 입력보다 더 작으면 프렛을 더하고 카운트 증가
				stack.add(fret);
				cnt++;
			} else if (stack.peek()==fret) {
				// 마지막 손가락이 입력과 같으면 아무것도 하지 않음
			} else {
				// 이런 케이스는 있을 수 없음
				throw new Exception();
			}
		}
		System.out.println(cnt);
	}
}
