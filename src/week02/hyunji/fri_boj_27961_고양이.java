package week02.hyunji;

import java.util.Scanner;

public class fri_boj_27961_고양이 {
    public static void main(String[] args) {
        // 입력값이 2의 지수승 범위 어디에 위치하는지 + 생성1 추가
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); //10^12 => long
        if(n==0) {
            System.out.println(0);
            return;
        }
        int cnt = 1;
        long numCats = 1;
        while(true) {
            if (numCats >= n) break; //범위로 들어오면 break하고 그때의 cnt출력
            
            numCats *= 2;
            cnt++;
        }
        System.out.println(cnt);
    }
}