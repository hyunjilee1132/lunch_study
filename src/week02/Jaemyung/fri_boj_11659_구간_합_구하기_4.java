import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class fri_boj_11659_구간_합_구하기_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

		int[] arr = new int[N+1]; // 수를 담아줄 배열
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		// 누적합을 배열에 담아준다
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st2.nextToken());
		}
		
		// M만큼 반복해주면서
		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st3.nextToken()); // 시작 인덱스
			int end = Integer.parseInt(st3.nextToken()); // 끝 인덱스
			
			// 끝 인덱스에서 시작 인덱스를 뺀 결과 출력
			bw.write(arr[end] - arr[start-1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
