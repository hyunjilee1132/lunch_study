package jonghwan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class thu_boj_9575_패션왕신해빈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = Integer.parseInt(sc.nextLine());
		
		
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			Map<String,Integer> map = new HashMap<String,Integer>();
			int cnt = Integer.parseInt(sc.nextLine());
			
			for (int i = 0; i < cnt; i++) {
				// 종류만 파악하고 종류별로 카운팅
				String[] input = sc.nextLine().split(" ");
				
				if (map.containsKey(input[1])) {
					map.put(input[1], map.get(input[1]) + 1);
				} else {
					map.put(input[1], 1);
				}
			}
			
			long ans = 1;
			
			for (String s: map.keySet()) {
			ans *= map.get(s) + 1;
			}
			
			System.out.println(--ans);

		}
	}
}
