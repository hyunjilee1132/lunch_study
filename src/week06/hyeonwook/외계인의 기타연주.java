import java.util.*;
import java.io.*;
public class boj2841 {
	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();
	static Stack<Integer> stack3 = new Stack<>();
	static Stack<Integer> stack4 = new Stack<>();
	static Stack<Integer> stack5 = new Stack<>();
	static Stack<Integer> stack6 = new Stack<>();
	static int cnt = 0;
	static void stack_pop_push(Stack<Integer> stack, int pret) {
		if (stack.isEmpty()) {
			stack.push(pret);
			cnt++;
		}
		else {
			while(!stack.isEmpty()) {
				int top = stack.peek();
				if (pret > top) {
					stack.push(pret);
					cnt++;
					break;
				} 
				else if (pret == top) {
					break;
				}
				else {
					stack.pop();
					cnt++;
				}
			}
			if (stack.isEmpty()) {
				stack.push(pret);
				cnt++;
			}
		}
	}
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		for (int x = 0; x < n; x++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st2.nextToken());
			int pret = Integer.parseInt(st2.nextToken());
			switch(line) {
			case 1:
				stack_pop_push(stack1,pret);
				break;
			case 2:
				stack_pop_push(stack2,pret);
				break;
			case 3:
				stack_pop_push(stack3,pret);
				break;
			case 4:
				stack_pop_push(stack4,pret);
				break;
			case 5:
				stack_pop_push(stack5,pret);
				break;
			case 6:
				stack_pop_push(stack6,pret);
				break;
			}
		}
		System.out.println(cnt);
	}
}
