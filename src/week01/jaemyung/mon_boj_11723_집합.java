import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mon_boj_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());

        // 인덱스 일치를 위해 길이 21의 배열 선언
        int[] arr = new int[21];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); //연산 회당 입력을 받을 것
            int num = 0; // 대상 숫자
            String name = st.nextToken(); // 연산

            if(!(name.equals("all") || name.equals("empty"))){
                num = Integer.parseInt(st.nextToken());
            }
            switch (name) {
                case "add":
                    arr[num] = 1;
                    break;

                case "remove":
                    arr[num] = 0;
                    break;

                case "check":
                    bw.write(arr[num]+"\n");
                    break;

                case "toggle":
                    arr[num] = (arr[num]+1)%2;
                    break;

                case "all":
                    Arrays.fill(arr,1);
                    break;

                case "empty":
                    Arrays.fill(arr,0);
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
