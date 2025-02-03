import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class tue_boj_11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int K = Integer.parseInt(st.nextToken()); // 동전의 가치 합

        List<Integer> arr = new ArrayList<>(); // 동전의 가치를 담아 줄 배열
        int count = 0; // 동전의 총 갯수를 담아줄 변수
        int amount = K;

        // 동전 종류별 가치를 오름차순으로 입력받는다
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            // 필요한 가치합을 초과하는 동전은 받지 않는다
            if (coin <= K) {
                arr.add(coin);
            }
        }

        // 가치배열을 내림차순으로 정렬해준다 (오름차순으로 입력받았기 때문에 그대로 반전)
        Collections.reverse(arr);

        // 배열을 순차적으로 순회하면서
        for (int value : arr) {
            // 동전의 가치가 K보다 같거나 작을때만
            if (value <= amount) {
                count += amount/value; // 잔액을 value로 나눈 몫을 더해주고
                amount = amount%value; // 나머지 금액을 잔액에 업데이트 해준다
            }
        }
        System.out.print(count);
    }
}