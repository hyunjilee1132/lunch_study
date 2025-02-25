import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tue_boj_14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()); // 세로 길이
		int W = Integer.parseInt(st.nextToken()); // 가로 길이
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		boolean isAboveZero = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				isAboveZero = false;
			}
		}
		
		if (isAboveZero) {
			for (int i = 0; i < arr.length; i++) {
				arr[i]--;
			}
		}
		
		int n = H;
		int m = W;
		
		int sum = 0;
		
		for (int i = n; i > 0; i--) {
			int cnt = 0;
			int subTotal = 0;
			for (int j = 0; j < m; j++) {
				if (arr[j] >= i) {
					cnt++;
				}
				
				if (cnt == 1) {
					subTotal++;
				}
				
				if (cnt == 2) {
					sum += subTotal -1;
					cnt = 0;
				}
			}
		}
		System.out.println(sum);
	}
}
