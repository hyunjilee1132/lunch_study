package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class thu_17219_비밀번호찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] rawInput = br.readLine().split(" ");
		
		int siteCnt = Integer.parseInt(rawInput[0]);
		int problemCnt = Integer.parseInt(rawInput[1]);
		
		Map<String,String> map = new HashMap<String,String>();
		
		for (int i = 0; i < siteCnt; i++) {
			String[] input = br.readLine().split(" ");
			map.put(input[0], input[1]);
		}
		
		for (int i = 0; i < problemCnt; i++) {
			bw.append(map.get(br.readLine()));
			
			if (i!= problemCnt -1)bw.append("\n");
		}
		bw.flush();
		
	}
}
