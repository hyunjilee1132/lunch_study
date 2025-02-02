import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class thu_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> arr = new HashMap<>(); // 키 벨류로 해시맵 사용

        // 사이트를 key, 암호를 value 형태로 HashMap에 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            arr.put(st2.nextToken(), st2.nextToken());
        }

        // 사이트에 맞는 비밀번호를 순차적으로 출력
        for (int i = 0; i < M; i++) {
            String search = br.readLine();
            System.out.println(arr.get(search));
        }
    }
}