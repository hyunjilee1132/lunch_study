package week02.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class wed_boj_2606_바이러스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		// 연결 정보를 담을 리스트배열
		List<Integer>[] cnnt = new ArrayList[n+1];
		
		// visited, 노드의 상태
		boolean[] isInfected = new boolean[n+1];
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cnnt[a] = cnnt[a]==null?new ArrayList<Integer>():cnnt[a];
			cnnt[b] = cnnt[b]==null?new ArrayList<Integer>():cnnt[b];
			cnnt[a].add(b);
			cnnt[b].add(a);
		}
		q.add(1);
		int cnt = 0;
		while (!q.isEmpty()) {
			int pos = q.poll();
			if (!isInfected[pos]) {
				isInfected[pos] = true;
				cnt++;
				// 그 노드의 연결 정보를 가져옴
				List<Integer> list = cnnt[pos]==null?new ArrayList<Integer>():cnnt[pos];
				
				// 연결된 노드를 감염시킴
				for (int next:list) {
					if (!isInfected[next]) {
						q.add(next);
					}
				}
			}
		}
		System.out.println(cnt-1);
	}
}