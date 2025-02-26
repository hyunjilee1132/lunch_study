import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Queue<Integer>> list = new ArrayList<>();
    
    // 각 포지션에 대해서 PQ를 만듬
		for (int i=0;i<=11;i++) {
			list.add(new PriorityQueue<Integer>(Comparator.reverseOrder()));
		}

    // 각 포지션에 선수를 집어넣음
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(p).add(w);
		}


    // 1년씩 진행하면서 PQ 첫번째 요소(가장 가치가 큰 선수)의 값을 줄임
		for (int i=0;i<k;i++) {
			for (int j=1;j<=11;j++) {
				Queue<Integer> queue = list.get(j);
				if (!queue.isEmpty()) {
					queue.add(Math.max(queue.poll()-1,0));
				}
			}
		}

    // 선발 선수 가치의 합을 구함
		long sum=0;
		for (int j=1;j<=11;j++) {
			Queue<Integer> queue = list.get(j);
			if (!queue.isEmpty()) {
				sum+=queue.poll();
			}
		}
		sb.append(sum);
		System.out.println(sb);
	}
}
