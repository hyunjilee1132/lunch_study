package week01.hyunji;

import java.io.*;
import java.util.*;

public class thu_boj_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String site = st2.nextToken();
			String passWord = st2.nextToken();
			
			map.put(site, passWord); //site: password
		}
		
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			
			//map안에 있으면 value 꺼내오기
			if (map.containsKey(input)) {
				String resPw = map.get(input);
				System.out.println(resPw);
			}
		}
	}
}
