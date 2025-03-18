import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int diff = y-x;
		
		int s = (int) Math.ceil(Math.sqrt(y-x));
		if (diff==0) {
			System.out.println(0);
		} else if (diff<=s*(s-1)) {
			System.out.println(s*2-2);
		} else {
			System.out.println(s*2-1);
		}
	}
}
