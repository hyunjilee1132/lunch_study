import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class wed_boj_2841_외계인의_기타_연주 {
	static String line;
	static int fret;
	static int cnt; // 횟수를 담아줄 변수 선언
	static Deque<Integer> deq1 = new ArrayDeque<>();
	static Deque<Integer> deq2 = new ArrayDeque<>();
	static Deque<Integer> deq3 = new ArrayDeque<>();
	static Deque<Integer> deq4 = new ArrayDeque<>();
	static Deque<Integer> deq5 = new ArrayDeque<>();
	static Deque<Integer> deq6 = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 멜로디에 포함된 N
		int P = Integer.parseInt(st.nextToken()); // 프렛의 수 P
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			line = st.nextToken();
			fret = Integer.parseInt(st.nextToken());
			
			switch (line) {
			case "1":
				func1(fret);
				break;
			case "2":
				func2(fret);
				break;
			case "3":
				func3(fret);
				break;
			case "4":
				func4(fret);
				break;
			case "5":
				func5(fret);
				break;
			case "6":
				func6(fret);
				break;
			}
		}
		// 정답 출력
		bw.write(cnt + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void func1(int fret) {
		deqCal(deq1, fret);
	}
	static void func2(int fret) {
		deqCal(deq2, fret);
	}
	static void func3(int fret) {
		deqCal(deq3, fret);
	}
	static void func4(int fret) {
		deqCal(deq4, fret);
	}
	static void func5(int fret) {
		deqCal(deq5, fret);
	}
	static void func6(int fret) {
		deqCal(deq6, fret);
	}

	private static void deqCal(Deque<Integer> deq, int fret) {
		// 들어온 프렛보다 직전의 프렛들이 작으면
		while (!deq.isEmpty() && deq.peekFirst() > fret) {
			deq.pollFirst(); // 해당 프렛을 떼면서
			cnt++; // 카운트를 증가시켜준다
		}

		// 직전의 프렛이 일치하지 않으면 함수 종료
		if (!deq.isEmpty() && deq.peekFirst() == fret) {
			return;
		}

		// 위의 조건에 해당하지 않을 경우 새로운 프렛 추가
		deq.addFirst(fret);
		cnt++;
    }
	
}
