package jonghwan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class fri_boj_11659_구간합구하기4 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] rawInput = br.readLine().split(" ");
		
		int size = Integer.parseInt(rawInput[0]);
		int tr = Integer.parseInt(rawInput[1]);
		
		long[] arr = new long[size];
		String[] rawArr = br.readLine().split(" ");
		
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(rawArr[i]);
		}
		
		long[] sum = new long[size];
		
		sum[0] = arr[0];
		for (int i = 1; i < size; i++) {
			sum[i] = arr[i] + sum[i-1];
		}
		
		for (int i = 0; i < tr; i++) {
			rawInput = br.readLine().split(" ");
			int start = Integer.parseInt(rawInput[0])-1;
			int end = Integer.parseInt(rawInput[1])-1;
			
			bw.append(( sum[end] - sum[start] + arr[start]) + "\n");
			
		}
		
		bw.flush();
		
		bw.close();
		br.close();

		
	}
}
