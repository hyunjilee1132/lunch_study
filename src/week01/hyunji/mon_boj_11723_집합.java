package week01.hyunji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mon_boj_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean[] exists = new Boolean[21]; // index 0: dummy, index 1~20: boolean
        for (int x = 1; x <= 20; x++) exists[x] = false;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String opr = br.readLine();

            if (opr.startsWith("add")) {
                String[] commands = opr.split(" ");
                int x = Integer.parseInt(commands[1]);
                exists[x] = true;
            }
            else if (opr.startsWith("remove")) {
                String[] commands = opr.split(" ");
                int x = Integer.parseInt(commands[1]);
                exists[x] = false;
            }
            else if (opr.startsWith("check")) {
                String[] commands = opr.split(" ");
                int x = Integer.parseInt(commands[1]);
                if(exists[x]) sb.append("1\n");
                else sb.append("0\n");
            }
            else if (opr.startsWith("toggle")) {
                String[] commands = opr.split(" ");
                int x = Integer.parseInt(commands[1]);
                exists[x] = !exists[x];
            }
            else if (opr.startsWith("all")) {
                for(int x = 1; x <= 20; x++) {
                    exists[x] = true;
                }
            }
            else if (opr.startsWith("empty")) {
                for(int x = 1; x <= 20; x++) {
                    exists[x] = false;
                }
            }
        }

        System.out.print(sb.toString());
    }
}