import java.util.*;
import java.io.*;
public class boj1669 {
	static int X,Y,day;
	static boolean finish = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		day = 2;
		if(Y==X) {
			day = 0;
		} else if(Y-X==1) {
			day = 1;
		} else if (Y-X==2) {
			day = 2;
		} else {
			X+=1;
			Y-=1;
			grow(1);
		}
		System.out.println(day);
	}
	static void grow(int height) {
		int h1 = height+1;
		if (Y-X>2*h1) {
			X+=h1;
			Y-=h1;
			day += 2;
			grow(h1);
		} else {
			if (Y-X>h1) {
				day+=2;
				return;
			} else {
				day+=1;
				return;
			}
		}
		return;
	}
}
