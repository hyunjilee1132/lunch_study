package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class mon_boj_1620_포켓몬마스터 {
	public static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
      }
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		int size = Integer.parseInt(inputs[0]);
		int prSize = Integer.parseInt(inputs[1]);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		String[] arr= new String[size+1];
		for (int i = 1; i <= size; i++) {
			String input = br.readLine();
			map.put(input, i);
			arr[i] = input;
		}
		
		for (int i = 0; i < prSize; i++) {
			String input = br.readLine();
			
			if (isNumberic(input)) {
				bw.append(arr[Integer.parseInt(input)]);
			} else {
				bw.append( map.get(input).toString());
			}
			bw.append("\n");
		}
		
		
		bw.flush();
		
		
	}
}
