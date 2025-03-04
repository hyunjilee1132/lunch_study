import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// 입력
		int n = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		
		int depth = 0;
		int max = 0;
		
		Stack<Character> stack = new Stack<>();

		for (int i=0;i<n;i++) {
			char c = str[i];
			if (c=='(') {
				if (stack.isEmpty()||stack.peek()=='(') {
					// O 중첩
					depth++;
					stack.add(c);
				} else {
					// X 제거
					depth--;
					stack.pop();
				}
			} else {
				if (stack.isEmpty()||stack.peek()==')') {
					// X 중첩
					depth++;
					stack.add(c);
				} else {
					// O 제거
					depth--;
					stack.pop();
				}
			}
			max = Math.max(max, depth);
		}
		
		if (!stack.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}
	}
}
