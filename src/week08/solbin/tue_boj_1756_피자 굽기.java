import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] oven = new int[d];
		st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		for (int i=0;i<d;i++) {
			min = Math.min(min, Integer.parseInt(st.nextToken()));
      // 오븐의 너비는 자기보다 더 얕은 오븐의 지름의 최솟값
			oven[i] = min;
		}
		st = new StringTokenizer(br.readLine());
    // 오븐의 깊은곳부터 피자가 들어갈 수 있는지 체크
		for (;d>=0&&n>0;n--) {
			int pizza = Integer.parseInt(st.nextToken());
      // 들어갈 수 있을 때 까지 오븐의 깊이를 감소시킴
			while (--d>=0&&oven[d]<pizza);
		}
		System.out.println(d+1);
	}
}
