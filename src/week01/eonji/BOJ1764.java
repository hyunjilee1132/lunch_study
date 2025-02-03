package lunch_study;
import java.util.*;
import java.io.*;
public class BOJ1764 {
    /**
     * 듣보잡
     * <a href="https://www.acmicpc.net/problem/1764">...</a>
     */
    /*
    처음에는 그냥 ArrayList로 풀었는데 시간초과 떠서
    뭔가 HashSet에 교집합 만드는 함수가 있었던 것 같은데 해서 찾아봄.
    .retainAll 찾아서 교집합 만들어 주고,
    정렬할 때 Collections.sort 쓰고 싶어서 만든 교집합을 또 ArrayList에 담아줌
     */
    public static void main(String[] args) throws IOException {
        // 개수 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        // 듣잡 hashset 만들어주기
        HashSet<String> noheard = new HashSet<>();
        for (int i = 0; i < n; i++) {
            noheard.add(br.readLine());
        }
        HashSet<String> noseen = new HashSet<>();
        for (int i = 0; i < m; i++) {
            noseen.add(br.readLine());
        }
        noheard.retainAll(noseen);
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(noheard.size() + "\n");
        for(String e : noheard) {
            res.add(e);
        }
        Collections.sort(res);
        for(String e : res) {
            sb.append(e +"\n");
        }
        System.out.println(sb.toString());
    }
}