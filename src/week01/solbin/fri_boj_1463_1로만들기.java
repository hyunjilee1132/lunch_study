import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n+1];
    	arr[1] = 0;
        // 초기값 세팅 후 DP로 n까지 생성함
    	for (int i=2;i<=n;i++) {
            // 1을 빼기
    		int min = arr[i-1]+1;
            // 3으로 나누기
    		if (i%3==0) min=arr[i/3]+1<min?arr[i/3]+1:min;
            // 2로 나누기
    		if (i%2==0) min=arr[i/2]+1<min?arr[i/2]+1:min;
            // 가장 작은 값을 저장함
    		arr[i] = min;
    	}
    	System.out.println(arr[n]);
    }
}
