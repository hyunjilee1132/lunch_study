package week01.hyunji;

import java.util.*;

public class mon_boj_1620_포켓몬마스터 {
    public static void main(String[] args) {
        //10^5 -> O(n)이내로 -> dict로 풀기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, String> doGamByNumber = new HashMap<>();
        HashMap<String, Integer> doGamByName = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = sc.next();
            doGamByNumber.put(i, name);
            doGamByName.put(name, i);
        }
        for (int i = 0; i < m; i++) {
            String input = sc.next();
            
            try {
                int num = Integer.parseInt(input);
                System.out.println(doGamByNumber.get(num));
            } catch (NumberFormatException e) {
                System.out.println(doGamByName.get(input));
            }
        }
    }
}