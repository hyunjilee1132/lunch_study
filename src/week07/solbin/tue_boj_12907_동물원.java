import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    static int cnt = 0;
    static int rabNum;
    static int catNum;
    static int n;
    static int[] arr;
    
    public static void main(String args[]) throws Exception {
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 토끼 마리수
        for (int i=0;i<=n;i++) {
        	rabNum = i;
        	catNum = n-i;
        	back(0,0,0);
        }
        
        System.out.println(cnt);
    }
    
    static void back(long rabBit, long catBit, int idx) {
    	if (idx==n) {
    		cnt++;
    		return;
    	}
    	int num = arr[idx];
    	long bit = (1L<<num);
    	if (rabNum>num&&(rabBit&bit)==0) {
    		back(rabBit|bit,catBit,idx+1);
    	}
    	if (catNum>num&&(catBit&bit)==0) {
    		back(rabBit,catBit|bit,idx+1);
    	}
    }
}
