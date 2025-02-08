package week02.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class thu_boj_9461_파도반수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			// 파도반 수열은 각 단계마다 3단계부터 시작해서 5각형을 이룸
			// 따라서 각 방향 변의 길이를 길이가 6인 배열에 저장할 수 있다.
			// 초기 상태 삼각형을 정의함.
			long[] arr = new long[] {0,1,0,1,0,1};
			
			// 맨 처음 더할 삼각형의 크기는 최초 삼각형의 한 변의 길이
			long size = arr[1]; 
			
			
			for (int i=1;i<n;i++) {
				// 한바퀴 돌면 다시 처음으로 오게끔
				int idx = i%6;
				
				// 자신의 양쪽에 있는 변의 길이를 자기 자신만큼 늘리고
				arr[b(idx-1)]+=arr[idx];
				arr[b(idx+1)]+=arr[idx];
				// 다음에 만들 삼각형의 길이는 자기 자신의 크기
				size = arr[idx];
				// 마지막으로 자기 자신을 0으로 만든다.
				arr[idx]=0;
			}
			sb.append(size+"\n");
		}
		System.out.println(sb);
	}
	
	static int b(int n) {
		return (n+6)%6;
	}
}