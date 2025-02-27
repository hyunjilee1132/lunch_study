import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = (int) Math.sqrt(n);
		int remain = n-k*k;
		int[] rabbit = new int[n+1];
		int[] cup = new int[k+2];
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			int sum=0;
			for (int j=a-1;j<=a+s-2;j++) {
				if (j%k==0&&j+k-1<=a+s-2) {
					sum+=++cup[j/k];
					j+=k-1;
				} else if(j%k==0&&j+n%k==a+s-1&&j+n%k==n) {
                                        sum+=++cup[j/k];
                                        break;
                                } else {
                                        sum+=++rabbit[j];
				}
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
}
