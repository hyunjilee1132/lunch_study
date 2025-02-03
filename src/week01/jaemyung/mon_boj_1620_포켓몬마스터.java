import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class mon_boj_1620_포켓몬마스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도감에 수록된 포켓몬의 갯수
        int M = Integer.parseInt(st.nextToken()); // 맞춰야 하는 문제의 개수
        // 1 <= N, M <= 100,000
        String[] poketArr = new String[N+1]; // 포켓몬 이름을 담아줄 배열 선언
        Map<String, Integer> numToNameArr = new HashMap<>(); // 이름을 key로 번호를 불러오는 해시맵 선언
        poketArr[0] = " "; // 인덱스를 맞추기 위해 0번에 공백을 넣어준다
        List<String> answerArr = new ArrayList<>(); // 정답을 담아줄 배열 선언

        // N개의 줄에 포켓몬의 번호가 1부터 N번에 해당하도록 입력으로 들어온다
        for (int i = 1; i <= N; i++) {
        	String name = br.readLine();
            poketArr[i] = name;
            numToNameArr.put(name, i);
        }
        
        // M개의 줄에 맞춰야 하는 문제가 입력된다
        // 알파벳 => 숫자 / 숫자 => 해당 포켓몬 번호에 해당하는 문자 출력
        for (int i = 0; i < M; i++) {
            String prob = br.readLine(); // 문제를 입력받고
            // 문제의 유형을 판별해준다.
            // 만약 들어온 문자의 첫 글자 숫자라면
            if (Character.isDigit(prob.charAt(0))) {
                answerArr.add(poketArr[Integer.parseInt(prob)]);
                // 그렇지 않다면
            } else {
//                answerArr.add(Integer.toString((Arrays.asList(poketArr).indexOf(prob))));
            	answerArr.add(Integer.toString(numToNameArr.get(prob)));
            }
        }

        // 순차적으로 출력한다!
        for (String name : answerArr) {
            System.out.println(name);
        }

    }
}
