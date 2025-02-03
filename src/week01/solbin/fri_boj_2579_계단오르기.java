import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
        // 계단이 1개일때를 고려하여 사이즈는 하나 더 키움
    	int[] score = new int[n+1];
    	int[] sum0 = new int[n+1];
    	int[] sum1 = new int[n+1];
    	for (int i=0;i<n;i++) {
    		score[i] = Integer.parseInt(br.readLine());
    	}

        // 초기값 세팅
        // sum0 배열은 두칸 건너서 해당 칸에 도착한 값
        // sum1 배열은 한칸 건너서 해당 칸에 도착한 값. 즉, 다음 칸은 무조건 두칸으로 건너야 함.
    	sum0[0] = score[0];
    	sum0[1] = score[1];
    	sum1[1] = score[0]+score[1];
        
        // DP로 한단계씩 최댓값을 늘려나감.
    	for (int i=2;i<n;i++) {
            // sum0은 두칸 이전의 sum0과 sum1을 비교해서 더 큰 값을 가져옴
    		int max0=sum1[i-2]>sum0[i-2]?sum1[i-2]:sum0[i-2];
    		sum0[i] = max0 + score[i];

            // sum1은 이전 계단에서 한칸 건너온 값
    		sum1[i] = sum0[i-1]+score[i];
    	}
    	int max=sum1[n-1]>sum0[n-1]?sum1[n-1]:sum0[n-1];
    	
    	System.out.println(max);
    }
}
