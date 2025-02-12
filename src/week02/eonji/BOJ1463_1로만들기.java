package Study.algorithm_lunchStudy;

import java.util.*;

public class BOJ1463_1로만들기 {  // 내가 푼 거 아니고 다른 사람 풀이 보고 이해함
    /**
     * 1로 만들기
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[1000001];


        // N의 경우의 수를 인덱스로 구분해서 다 담아줌
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 3;
        //...

        for (int i = 3; i < arr.length; i++) {
            int temp1 = 1000001;
            int temp2 = 1000001;
            int temp3 = 1000001;
            int min = 1000001;

            temp1 = arr[i-1] + 1;

            if(i%2 == 0) {
                temp2 = arr[i/2] + 1;
            }

            if(i%3 == 0) {
                temp3 = arr[i/3] + 1;
            }

            min = Math.min(temp1, Math.min(temp2, temp3));
            arr[i] = min;
        }

        System.out.println(arr[N]);
    }

}
