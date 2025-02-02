package week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class fri_boj_1463_1로만들기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int target = sc.nextInt();
		
		boolean[] visited = new boolean [target+1];
		
		// q를 이용한 bfs로 1에서부터 시작해서 몇초만에 도달하는지 계산.
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		q.add(1);
		
		int ans = 0;
		
		outer:
		for (int time = 0; time <10000; time++) {
			int tr = q.size();
			
			for (int j = 0; j < tr; j++) {
				int num = q.poll();
				
				if (visited[num]) {
					continue;
				} else if (num == target) {
					ans = time;
					break outer;
				} else if ( !visited[num]){
					visited[num] = true;
					q.add(num+1);
					if ( num * 2 <= target) {
						q.add(num*2);
						if ( num * 3 <= target) {
							q.add(num*3);
						}
					}

				}
				
			}
		}
		
		System.out.println(ans);
	}
}
