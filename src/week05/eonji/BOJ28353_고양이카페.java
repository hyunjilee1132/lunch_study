package groupstudy.algorithm_lunchStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ28353_고양이카페 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 전체 고양이 수
        int K = Integer.parseInt(input[1]); // 견딜 수 있는 고양이 2마리 무게 합
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i= 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = arr.length-1;
        int res = 0;

        while(left < right) {
            if (arr[left] + arr[right] <= K) {
                res ++;
                left ++;
                right--;
            } else {
                right--;
            }
        }

        System.out.println(res);
    }
}
