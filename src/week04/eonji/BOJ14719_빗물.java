package groupstudy.algorithm_lunchStudy;

import java.io.*;
import java.util.*;

// 사실 투포인터 쓰는 거 스포 당하고 풀었어요,,,,ㅎ

public class BOJ14719_빗물 {
    /**
     * 빗물
     * <a href="http://acmicpc.net/problem/14719">...</a>
     */
    public static void main(String[] args) throws IOException {
        /// 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투포인터 만들기
        int left = 0;
        int right = arr.length - 1;
        int leftMax = arr[left];
        int rightMax = arr[arr.length-1];
        int cnt = 0;

        while (left < right) {
            if(arr[left] < arr[right]){
                left ++;
                if(arr[left] >= leftMax){
                    leftMax = arr[left];
                } else {
                    cnt += (leftMax - arr[left]);
                }
            }

            else {
                right --;
                if(arr[right] >= rightMax){
                    rightMax = arr[right];
                } else {
                    cnt += (rightMax - arr[right]);
                }
            }
        }

        System.out.println(cnt);
    }
}
