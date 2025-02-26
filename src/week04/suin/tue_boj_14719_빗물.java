import java.util.Scanner;
import java.util.StringTokenizer;

// 빗물
public class BOJ14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];

        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < w; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int lt = 0;
        int rt = w - 1;
        int leftMax = arr[lt];
        int rightMax = arr[rt];
        while (lt < rt) {
            if (leftMax < arr[lt])
                leftMax = arr[lt];
            if (rightMax < arr[rt])
                rightMax = arr[rt];

            if (leftMax <= rightMax) {
                answer += leftMax - arr[lt];
                lt++;
            } else {
                answer += rightMax - arr[rt];
                rt--;
            }

        }
        System.out.println(answer);
    }
}
