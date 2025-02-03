package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class mon_boj_11723_집합 {
	
	public static void main(String args[]) throws NumberFormatException, IOException 
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int orderCnt = Integer.parseInt(bf.readLine());
		
		// 입력 편의를 위해 20 +1
		// false면 비어있고, true면 그 숫자가 있는것으로 간주.
		boolean[] arrS = new boolean[21]; 
		
		for (int i = 0; i < orderCnt; i++) {
			String[] input =  bf.readLine().split(" ");
			
			if (input.length == 2) {
				int target = Integer.parseInt(input[1]);
				
				if (input[0].equals("add")) {
					arrS[target] = true;
					
				}else if (input[0].equals("check")) {
					bw.write((arrS[target]?"1\n":"0\n"));
					
				}else if (input[0].equals("remove")) {
					arrS[target] = false;
					
				}else {
					arrS[target] = arrS[target]?false:true;
					
				}
			} else if (input[0].equals("all")) {
				for (int j = 1; j <= 20; j++ ) {
					arrS[j] = true;
				}
			} else {
				for (int j = 1; j <= 20; j++ ) {
					arrS[j] = false;
				}
			}
			
		}
		
		bw.flush();
			

		
	}
}
