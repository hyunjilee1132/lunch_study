import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int v;
	static int m;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double xs = Double.parseDouble(st.nextToken());
		double ys = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double xt = Double.parseDouble(st.nextToken());
		double yt = Double.parseDouble(st.nextToken());
		
		List<double[]> bunker = new ArrayList<>();
		List<List<Integer>> path = new ArrayList<>(); 
		
		// 시작지점은 0번 인덱스
		bunker.add(new double[] {xs,ys});
		
		while (br.ready()) {
			st = new StringTokenizer(br.readLine());
			if (!st.hasMoreTokens()) break;
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			bunker.add(new double[] {x,y});
		}
		// 종료지점은 마지막;
		bunker.add(new double[] {xt,yt});
		
		// 간선 list를 생성
		for (int i=0;i<bunker.size();i++) {
			path.add(new ArrayList<>());
		}
		
		for (int i=0;i<bunker.size()-1;i++) {
			double[] s = bunker.get(i);
			for (int j=i+1;j<bunker.size();j++) {
				double[] e = bunker.get(j);
				if (isPossible(s,e)) {
					path.get(i).add(j);
					path.get(j).add(i);
				}
			}
		}
		
		// BFS
		Deque<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[bunker.size()];
		visited[0] = true;
		// 0 : index , 1 : cost
		queue.add(new int[] {0,0});
		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			for (int i : path.get(item[0])) {
				if (i==bunker.size()-1) {
					System.out.println("Yes, visiting " + item[1] + " other holes.");
					return;
				}
				if (!visited[i]) {
					visited[i] = true;
					queue.add(new int[] {i,item[1]+1});
				}
			}
		}
		System.out.println("No.");
	}
	
	static boolean isPossible(double[] s, double[] e) {
		return Math.sqrt(Math.pow(s[0]-e[0], 2)+Math.pow(s[1]-e[1], 2))<=v*m*60;
	}
}
