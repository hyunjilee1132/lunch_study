package lunch_study;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
    /**
     * 두 번째 시도
     * 나는야 포켓몬 마스터 이다솜
     * <a href="https://www.acmicpc.net/problem/1620">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> mapbynumber = new HashMap<>();
        HashMap<String, Integer> mapbypoketmon = new HashMap<>();
        for (int n = 1; n <= N; n++) {
            String poketmon = br.readLine();
            mapbynumber.put(n, poketmon);
            mapbypoketmon.put(poketmon, n);
        }

        for(int m = 0 ; m < M ; m++) {
            String q = br.readLine();
            if(mapbypoketmon.containsKey(q)) {
//                bw.write(mapbypoketmon.get(q));   // bw.write에 정수값을 넘겨주면 그 정수값에 해당하는 유니코드 문자를 출력한다!
                bw.write(mapbypoketmon.get(q) + "\n");
            } else if(mapbynumber.containsKey(Integer.parseInt(q))) {
                bw.write(mapbynumber.get(Integer.parseInt(q)) + "\n");
            }
        }

        bw.flush();
        bw.close();


    }
}
