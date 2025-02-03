import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class tue_boj_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 결국 N과 M에 중복되는 사람의 수와 이름을 출력하는 것이다
        // 알고리즘 분류 : 자료 구조, 문자열, 정렬, 해시를 사용한 집합과 맵

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수

        // 중복이 없으므로 HashSet을 사용해본다.
        HashSet<String> arr = new HashSet<>();
        int count = 0; // 중복되는 사람의 수
        List<String> nameArr = new ArrayList<>(); // 중복되는 사람의 이름을 담아줄 배열

        // 듣도 보도 못한 사람을 순서대로 담아 담아주는데
        for (int i = 0; i < N+M; i++) {
            String name = br.readLine();
            // 만약 입력 중 false를 반환하면 사람수를 증가시키고 sb에 이름을 담아준다
            if (arr.add(name)) {
                arr.add(name);
            } else {
                count++; // 사람수를 증가시키고
                nameArr.add(name); // 중복되는 사람의 이름을 배열에 담아준다
            }
        }

        Collections.sort(nameArr); // nameArr의 요소를 사전순 정렬시키고

        System.out.println(count); // 정답 출력
        for (String name : nameArr) {
            System.out.println(name);
        }
    }
}
