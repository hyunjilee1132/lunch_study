package week03.solbin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


class fri_boj_27515_1Â÷¿ø2048°úÄõ¸® {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	int n = Integer.parseInt(br.readLine());
    	int[] cnt = new int[63];
    	for (int i=0;i<n;i++) {
    		String input = br.readLine();
    		long num = Long.parseLong(input.substring(1));

            // 입력을 받으면 해당 차수 카운트를 하고 출력을 한다
    		if (input.charAt(0)=='+') {
    			int r = rt(num);
    			if (r!=-1) {
    				cnt[r]++;
    			}
    			calc(Arrays.copyOf(cnt, 63));
    		} else {
    			int r = rt(num);
    			if (r!=-1) {
    				cnt[r]--;
    			}
    			calc(Arrays.copyOf(cnt, 63));
    		}
    	}
    	System.out.println(sb);
    }
    
    static void calc(int[] cnt) {
    	for (int i=0;i<62;i++) {
    		cnt[i+1]+=cnt[i]/2;
    	}
    	int idx = 63;
    	while (idx>0&&cnt[--idx]==0) {
    	}
    	if (idx==0) {
    		if (cnt[0]==0) {    			
    			sb.append("0\n");
    		} else {
    			sb.append("1\n");
    		}
    	} else {    		
    		sb.append(1L<<idx).append("\n");
    	}
    }
    
    static int rt(long x) {
    	if (x==0) {
    		return -1;
    	}
    	return Long.numberOfTrailingZeros(Long.highestOneBit(x));
    }
} 
