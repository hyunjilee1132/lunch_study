import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class wed_boj_29160_나의_FIFA_팀_가치는 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 총 선수의 수
		int K = Integer.parseInt(st.nextToken()); // 년도
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			// 같은 포지션에 대하여 가치 순으로 오름차순 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]==o2[0]) return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
			
		});
		
		// 선수의 포지션과 가치를 우선순위 큐에 담아준다.
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st2.nextToken()); // 선수의 포지션
			int W = Integer.parseInt(st2.nextToken()); // 선수의 가치
			
			pq.add(new int[] {P, W});
			
		}
		
		HashMap<Integer, Integer> map = new HashMap<>(); // 중복제거를 위한 해시맵 선언
		
		// 우선순위 큐가 빌때까지 돌면서
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll(); 
			int key = tmp[0]; // map의 key와 value로 사용할 값을 빼준다
			int val = tmp[1];
			
			map.put(key, val);
		}
		// 가치의 합을 담아줄 변수 선언
		int cnt = 0;
		
		// map의 키를 순회하면서
		for (int i : map.keySet()) {
			if (map.get(i) >= K) {
				cnt += map.get(i)-K;
			}
		}
		
		bw.write(String.valueOf(cnt));
	
		bw.flush();
		bw.close();
		br.close();
	} // main 끝
	
} // 클래스 끝

// 답은 출력이 되는데 틀렸습니다... 가르침 부탁...
