import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] input = br.readLine().split(" ");
    	int n = Integer.parseInt(input[0]);
    	int k = Integer.parseInt(input[1]);
    	int[] arr = new int[n];
    	for (int i=0;i<n;i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	Arrays.sort(arr);
    	int idx = n-1;
    	int cnt = 0;
    	int sum = 0;
    	while (sum<k&&idx>=0) {
            // 동전을 더할 수 있으면 더하기
    		if (sum+arr[idx]<=k||idx==0) {
    			int val = (k-sum)/arr[idx];
    			sum+=val*arr[idx];
    			cnt+=val;
    		} else {
    			idx--;
    		}
    	}
        // 마지막 동전으로 부족한 부분 채움
        if (sum!=k) {
            cnt++;
        }
    	System.out.println(cnt);
    }
}
