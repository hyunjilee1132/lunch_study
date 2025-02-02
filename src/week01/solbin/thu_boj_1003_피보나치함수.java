import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] fibo = new int[43];
    	fibo[0] = 1;
    	fibo[1] = 0;
    	fibo[2] = 1;
    	fibo[3] = 1;
        // 0 호출과 1 호출 횟수를 직접 적어서보면 결국은 피보나치 배열 맨 앞에 1, 0 하나 추가한것임
    	for (int i=4;i<43;i++) {
    		fibo[i] = fibo[i-1] + fibo[i-2];
    	}
    	int T = Integer.parseInt(br.readLine());
    	for (int t=1;t<=T;t++) {
    		int n = Integer.parseInt(br.readLine());
    		sb.append(fibo[n]+" "+fibo[n+1]+"\n");
    	}
    	System.out.println(sb);
    }
}
