import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class fri_boj_27514_1차원_2048 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Stream.of(br.readLine().split(" "))
						  .mapToInt(Integer::parseInt)
						  .toArray();
		
		// 조건이 충족될 때 까지 while문을 통하여 반복
		boolean isChanged = true;
		
		while (isChanged) {
			isChanged = false; // 배열이 변하지 않은 것으로 상태 변경
			// 배열을 순회하면서
			for (int i = 0; i < N; i++) {
				if (arr[i] == 0) continue; // arr[i]가 0이라면 건너뛴다
				for (int j = i+1; j < N; j++) {
					if (arr[j] == 0) continue; // arr[j]가 0이라면 건너뛴다
					// 만약 arr[i] 와 arr[j] 가 동일하다면 
					if (arr[i] == arr[j]) {
						arr[i] *= 2; // arr[i]는 두배를 곱해주고
						arr[j] = 0; // arr[j]는 0으로 만들어준다
						isChanged = true; // 배열에 변화가 있었으니 true로 변경 -> while문 추가 동작 가능
//						System.out.println("반복문 중간의 arr : "+ Arrays.toString(arr));
						break;
					}
				}
			}
		}
		
		System.out.println(Arrays.stream(arr).max().getAsInt());
		
	} // main 끝
	
} // 클래스 끝

// 출력결과 2048 나오지만 런타임 에러가 나왔는데 일단 올려봅니다...
