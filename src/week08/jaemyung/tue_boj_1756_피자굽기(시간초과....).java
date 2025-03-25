import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class tue_boj_1756_피자굽기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken()); // 오븐의 깊이 D
		int N = Integer.parseInt(st.nextToken()); // 피자 반죽의 개수 N
		int idx = D;
		
		int[] depthArr = new int[D+1]; // 오븐의 넓이를 담아줄 배열 선언
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= D; i++) {
			depthArr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for (int j = 1; j <= idx; j++) {
				cnt++;
				if (tmp > depthArr[j]) {
					idx = j-1;
					break;
				}
			}
			if (cnt == idx) {
				idx--;
			}
		}
		
		bw.write(idx + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	} // main
	
} // class
