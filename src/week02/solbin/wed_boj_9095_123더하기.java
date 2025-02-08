package week02.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class wed_boj_9095_123더하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(calc(num)+"\n");
		}
		System.out.println(sb);
	}
	
	// n이 충분히 작기 때문에 재귀로 풀었지만 n이 조금만 더 커진다면 dp로 풀었을듯
	// 또는 파스칼 삼각형과 유사하기 때문에 조합으로 풀 수 있을지도
	static int calc(int n) {
		if (n==0) {
			return 1;
		} else if (n<0) {
			return 0;
		}
		return calc(n-1)+calc(n-2)+calc(n-3);
	}
}