import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] cat = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			cat[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(cat);
		
		int sum = 0;
		// 가장 가벼운 고양이
		int s = 0;
		// 가장 무거운 고양이
		int e = n-1;
		while (s<e) {
			int cat1 = cat[s];
			int cat2 = cat[e];
			if (cat1+cat2>k) {
				// 고양이 두마리 무게가 k 초과면 더 작게 만들기 위해서 더 작은 고양이를 데려온다
				e--;
			} else {
				// 고양이 조합이 완성되면 다음 고양이를 불러온다
				sum++;
				s++;
				e--;
			}
		}
		System.out.println(sum);
	}
}
