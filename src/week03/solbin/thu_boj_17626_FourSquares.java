package week03.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class thu_boj_17626_FourSquares {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Set<Integer> pow = new HashSet<>();
	static int last;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.valueOf(br.readLine());
		
		// 모든 제곱수들을 계산함
		for (int i=1;i<=Math.sqrt(n);i++) {
			pow.add(i*i);
		}
		byte[] arr = new byte[n+1];
		// 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있으므로
		// 일단 4로 채워놓고 시작함
		Arrays.fill(arr, (byte)4);
		
		for (int i=1;i<=n;i++) {
			byte min = 4;
			// 하나의 제곱수로 표현할 수 있는지 체크
			if (pow.contains(i)) {
				min = 1;
			} else {
				// 제곱수 집합
				for (int j:pow) {
					// 이전에 계산했던 제곱수의 갯수와 비교하여 낮은 값을 할당함
					if (i-j>=0) min=(byte) (arr[i-j]+1<min?arr[i-j]+1:min);
				}
			}
			arr[i] = min;
		}
		System.out.println(arr[n]);
	}
}