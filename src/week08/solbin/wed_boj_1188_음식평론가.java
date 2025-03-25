import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cut = 0;
		
		for (int i=n;i<n*m;i+=n) {
			if (gcd(i,m)!=m) {
				cut++;
			}
		}
		System.out.println(cut);
	}
	
	static int gcd(int x,int y) {
		return y==0?x:gcd(y,x%y);
	}
}
