import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// 1차원 2048
public class BOJ27514 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(sc.nextLine());
        List<Long> arr = new ArrayList<>();
        long total = 0;
        for (int i = 0; i < n; i++) {
            arr.add(Long.parseLong(st.nextToken()));
            total += arr.get(i);
        }

        // total이 2의 몇승인지 구하고, 그 바로 승까지가 구할 수 있는 최대 2의 승
//        int cnt = 0;
//        while (total >= 2) {
//            cnt++;
//            total /= 2;
//        }

        int cnt = (int) (Math.log(total) / Math.log(2));
        if (cnt == 0) {
            System.out.println(1);
            return;
        }

        long answer = (long) Math.pow(2, cnt);
        System.out.println(answer);

    }
}
