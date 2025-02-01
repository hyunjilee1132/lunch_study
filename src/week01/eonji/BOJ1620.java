package Study.algorithm_lunchStudy;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(i + 1, br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            if(map.containsValue(q)) {

            } else if (map.containsKey(Integer.parseInt(q))){
                bw.write(map.get(Integer.parseInt(q)) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
