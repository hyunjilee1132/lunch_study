package week01.hyunji;

import java.io.IOException;
import java.util.*;

public class tue_boj_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            map.put(name, 0);
        }
        for (int j = 0; j < m; j++) {
            String name1 = sc.next();
            if (map.containsKey(name1)) {
                int cnt = map.get(name1);
                cnt++;
                map.put(name1, cnt);
            }
        }
        int totalCnt = 0;
        ArrayList<String> arrList = new ArrayList<>();
        for (String name : map.keySet()) {
            if (map.get(name) > 0) {
                totalCnt++;
                arrList.add(name);
            }
        }    

        Collections.sort(arrList);

        System.out.println(totalCnt);
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
    }
}