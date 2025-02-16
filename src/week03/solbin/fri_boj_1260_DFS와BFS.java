package week03.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.StringTokenizer;
public class fri_boj_1260_DFS와BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static boolean[] bVstd;
	static boolean[] dVstd;
	
	static ArrayList<Integer>[] cnnts;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		bVstd = new boolean[n+1];
		dVstd = new boolean[n+1];
		
		cnnts = new ArrayList[n+1];
		
		// 데이터 받아오는 부분
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			cnnts[x] = Optional.ofNullable(cnnts[x]).orElse(new ArrayList<Integer>());
			cnnts[x].add(y);
			
			cnnts[y] = Optional.ofNullable(cnnts[y]).orElse(new ArrayList<Integer>());
			cnnts[y].add(x);
			
			Collections.sort(cnnts[x]);
			Collections.sort(cnnts[y]);
		}
		
		// DFS는 재귀
		dfs(v);
		
		System.out.print(sb+"\n");
		sb.setLength(0);
		
		// BFS는 Queue
		queue.add(v);
		bVstd[v] = true;
		
		while (!queue.isEmpty()) {
			int pos = queue.poll();
			sb.append(pos + " ");
			if (cnnts[pos]!=null) {
				for (int i:cnnts[pos]) {
					if (!bVstd[i]) {
						queue.add(i);
						bVstd[i] = true;
					}
				}
			}
		}
		System.out.println(sb);
	}
	
	// DFS
	static void dfs(int n) {
		if (!dVstd[n]) {
			sb.append(n+" ");
			dVstd[n] = true;
			if (cnnts[n]!=null) {
				for (int i:cnnts[n]) {
					if (!dVstd[i]) {
						dfs(i);
					}
				}
			}
		}
	}
}