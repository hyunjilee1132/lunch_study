import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fri_boj_28353_고양이_카페 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 고양이의 마리수 N
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 고양이 무게의 합 K
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		// 고양이의 마리수만큼 고양이 무게를 배열에 담아준다
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 고양이를 무게순으로 정렬해준다
		Arrays.sort(arr);
		
		// 양끝에 포인터의 위치를 잡아준다
		int left = 0;
		int right = N-1;
		
		int cnt = 0; // 만족하는 사람의 수
		// 좌우 포인테가 곂칠 때까지 돌면서
		while (left <= right) {
			tmp++;
			if (left == right) break;
			// 만약 좌우측 고양이의 무게 합이 버틸 수 있는 무게보다 크면
			if (arr[left] + arr[right] > K) {
				right--;
				// 반대의 경우라면
			} else {
				right--;
				left++;
				cnt++;
			}
		}
		
		// 정답 출력
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	} // main 끝
	
} // 클래스 끝
