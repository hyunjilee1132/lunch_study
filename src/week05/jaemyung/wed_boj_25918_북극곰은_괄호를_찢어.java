// O 모양은 찢으면 () , X모양을 찢으면 )( 가 되나봄

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class wed_boj_25918_북극곰은_괄호를_찢어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 괄호문자열의 길이
		String[] S = br.readLine().split(""); // 만들여야 하는 문자열
		
		// 괄호들을 담아줄 stack 선언 (Deque 사용)
		Deque<String> stack = new ArrayDeque<>();
		int max = 0; // 최대 날짜수를 기록해준다
		
		// stack에 괄호를 하나씩 담아준다
		for (String s : S) {
			if (stack.isEmpty()) {
				stack.addFirst(s);
			} else {
				if (stack.peekFirst().equals("(") && s.equals(")")) {
					stack.removeFirst();
					max = Math.max(max, stack.size());
				} else if (stack.peekFirst().equals(")") && s.equals("(")) {
					stack.removeFirst();
				}else {
					stack.addFirst(s);
				}
			}
			max = Math.max(max, stack.size());
		}
		
		if (stack.isEmpty()) {
			System.out.println(max);
		} else {
			System.out.println(-1);
		}
		
	}
}
