package week01.hyunji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fri_boj_1463_1로만들기 {
	public static void main(String[] args) throws IOException {
		//배열에 연산횟수 넣기 - 들어오는 값 찾아서 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		int[] dp = new int[x+1];
		
		dp[1] = 0;
		
        //인덱스에러 => 수정
		if (x >= 2) { 
			dp[2] = 1;
		}
		
		for (int i=3; i<=x; i++) {
			dp[i] = dp[i-1] + 1;
				
			if (i%3==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if (i%2==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
		}
		
		System.out.println(dp[x]);
	}
}
