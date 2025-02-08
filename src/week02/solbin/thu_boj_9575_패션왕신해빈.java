package week02.solbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
public class thu_boj_9575_패션왕신해빈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			Map<String,Integer> map = new HashMap<>();
			for (int i=0;i<n;i++) {
				String[] input = br.readLine().split(" ");
				// 첫번째 입력인 옷의 이름은 무시한다.
				// 두번째 입력인 옷의 종류를 Key로 HashMap에 Count한다.
				int cnt = Optional.ofNullable(map.get(input[1])).orElse(0);
				map.put(input[1], cnt+1);
			}
			int comb=1;
			
			// 그 종류를 아예 입지 않는 경우의 수를 하나 더하고 경우에 수에 곱한다.
			// 수열의 곱 Pie
			for (int i:map.values()) {
				comb*=i+1;
			}
			
			// 모든 종류를 아예 입지 않는 경우 딱 하나를 빼서 출력을 함.
			sb.append(comb-1+"\n");
		}
		System.out.println(sb);
	}
}