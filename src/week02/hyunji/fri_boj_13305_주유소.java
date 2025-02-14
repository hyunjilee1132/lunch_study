package week02.hyunji;

import java.util.*;

public class fri_boj_13305_주유소 {
    public static void main(String[] args) {
        // 도착지까지 도달하는데 최소비용 만들기 => 금액 최소로 맞추기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //거리
        long[] dist = new long[n-1]; // 10^9
        for(int i=0; i<n-1; i++) {
            dist[i] = sc.nextLong();
        }

    	//가격
    	long[] cost = new long[n]; //10^9
    	for(int i=0; i<n; i++) {
        	cost[i] = sc.nextLong();
    	}

    	long minCost = cost[0]; 
    	for(int i=1; i<n; i++) { // 코스트 => 양옆이랑 비교해서 최소로 맞춰주기기
        	if(cost[i] > minCost) {
            	cost[i] = minCost;
        	}
        	else { //cost[i] <= minCost
            	minCost = cost[i];
        	}
    	}

		long sum = 0;
		for(int i=0; i<n-1; i++) {
			sum += dist[i] * cost[i];
		}

		System.out.println(sum);
	}
}