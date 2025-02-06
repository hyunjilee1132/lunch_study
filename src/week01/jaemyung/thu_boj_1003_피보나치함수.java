import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class thu_boj_1003_피보나치함수 {
	// 0과 1을 카운트하기 위해 전역변수로 선언
	static int cntZero = 0;
	static int cntOne = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		while(T > 0) {
			T--; // 테스트케이스 돌입 시 T가 감소
			
			int N = Integer.parseInt(br.readLine()); // 주어지는 숫자
			
			// 피보나치 함수에 N값을 넣어준다.
			fibonazzi(N);
			
			// 0과 1의 카운트 값 출력
//			System.out.printf("%d %d\n", cntZero, cntOne);
			bw.write(cntZero + " " + cntOne + "\n");
			
			// 한번의 테스트케이스 연산이 끝나면 cntZero는 다시 초기화
			cntZero = 0;
			cntOne = 0;
		}
		bw.flush();
		bw.close();
		br.close();
	} // 메인함수 끝
	
	// 피보나치 함수
	public static int fibonazzi (int N) {
		if (N == 0) {
			cntZero++;
			return 0;
		} else if (N == 1) {
			cntOne++;
			return 1;
		} else {
			return fibonazzi(N-1) + fibonazzi(N-2);
		}
	}
	
} // 클래스 끝
