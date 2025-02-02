package lunch_study;

import java.util.HashSet;
import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11723 {
    /**
     * 집합
     */
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int num = 0;

        for(int i= 0 ; i < n ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String cal = st2.nextToken();
            if (st2.hasMoreTokens()) {
                num = Integer.parseInt(st2.nextToken());
            }
            calculator(cal, num);
        }
        System.out.println(sb.toString());

    }

    private static void calculator(String cal, int num) throws IOException {
        if (cal.equals("add")) {
            set.add(num);
        } else if (cal.equals("check")) {
            if (set.contains(num)) {
                sb.append(1 + "\n");
            }
            else {
                sb.append(0 + "\n");
            }
        } else if (cal.equals("remove")) {
            set.remove(num);
        } else if (cal.equals("toggle")) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        } else if (cal.equals("all")) {
            set.clear();
            for (int i = 1; i <= 20; i++) {
                set.add(i);
            }
        } else if (cal.equals("empty")) {
            set.clear();
        }
    }
}
