import java.util.*;
import java.io.*;
public class boj12907 {
	static int[] rabbits, cats, animals;
	static int N, cnt;
	static boolean impossible = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		animals = new int[N];
		rabbits = new int[N];
		cats = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int j = 0;
		while(st.hasMoreTokens()) {
			animals[j] = Integer.parseInt(st.nextToken());
			j++;
		}
		cnt = 0;
		Arrays.sort(animals);
		animal_pick(0);
		System.out.println(cnt);
	}
	static void animal_pick(int idx) {
		if (idx == N) {
			cnt++;
			return;
		}
		int h = animals[idx];
		if (h >= N) {
			impossible = true;
			return;
		}
		else {
			boolean impossible2 = true;
			if (rabbits[h] == 0) {
				if (h==0) {
					impossible2 = false;
					rabbits[h] = 1;
					animal_pick(idx+1);
					if (impossible) {
						return;
					}
				} else {
					if (rabbits[h-1]==1) {
						impossible2 = false;
						rabbits[h] = 1;
						animal_pick(idx+1);
						if (impossible) {
							return;
						}
					}
				}
				rabbits[h] = 0;
			}
			if (cats[h] == 0) {
				if (h==0) {
					impossible2 = false;
					cats[h] = 1;
					animal_pick(idx+1);
					if (impossible) {
						return;
					}
				} else {
					if(cats[h-1]==1) {
						impossible2 = false;
						cats[h] = 1;
						animal_pick(idx+1);
						if (impossible) {
							return;
						}
					}
				}
				cats[h] = 0;
			}
			if (impossible2) {
				impossible = true;
				return;
			}
		}
	}
}
