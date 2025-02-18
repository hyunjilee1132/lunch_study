package week03.hyunji;

import java.util.Scanner;

public class wed_boj_11726_2xn타일링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] dp = new int[1001];
        /*
        배열 크기를 n으로 하면 1로 접근했을때 인덱스에러 => 1로 하면 0까지만 탐색 가능한데, dp[1]이 있다고 하니까 인덱스가 헛돈다
        이럴땐 n의 크기가 많이 크지 않다면 최댓값+1로 넉넉하게 설정해놓고 시작하는게 편함
        */
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<n; i++) {
            dp[i] = dp[i-2]%10007 + dp[i-1]%10007;
            /*
            10007을 과정이랑 결과에 모두 나눠주는 이유?
            1. 결국 구하고자 하는건 dp[i]%10007인데, 당장 구할 수 없으니 => A%10007 == (B%p + C%p)%p로 우회해서 구하기 
            2. dp 만드는 과정에서도 원소 각각 10007로 나누고 나머지를 저장해야 int형 범위를 안넘어감
            */
        }

        System.out.println(dp[n-1]%10007); 
        //결국 dp[n-1]은 나머지들의 합인거지, 10007을 직접 나눈 값이라고 보장할 수 없다 => 그렇기때문에 dp[n-1]도 한번 더 나눠줘야 정확한 값이 나옴
    }
}
