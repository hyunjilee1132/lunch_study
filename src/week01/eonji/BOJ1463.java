package Study.algorithm_study;

import java.io.*;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[100001];

//        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
//        arr[4] = 2;
//        arr[5] = 3;

        for (int i = 4; i < arr.length; i++) {
            int temp1 = 100000;
            int temp2 = 100000;
            int temp3 = 100000;
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    temp1 = arr[i-1];
                } else if (j == 1) {
                    if (i % 2 == 0)
                        temp2 = arr[i / 2];
                } else {
                    if (i % 3 == 0)
                        temp3 = arr[i / 3];
                }
            }
            int min = Math.min(temp1, Math.min(temp2, temp3));
            arr[i] = min + 1;
        }

        System.out.println(arr[N]);
    }
}
