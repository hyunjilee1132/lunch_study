package week03.solbin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class fri_boj_27514_1Â÷¿ø2048 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	int n = Integer.parseInt(br.readLine());
    	int[] cnt = new int[63];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=0;i<n;i++) {
    		long input = Long.parseLong(st.nextToken());
    		if (input!=0) {
    			cnt[rt(input)]++;
    		}
    	}
    	for (int i=0;i<62;i++) {
    		cnt[i+1]+=cnt[i]/2;
    	}
    	int idx = 63;
    	while (cnt[--idx]==0) {
    		
    	}
        System.out.println(1L<<idx);
    }
    
    static int rt(long x) {
    	return Long.numberOfTrailingZeros(Long.highestOneBit(x));
    }
} 