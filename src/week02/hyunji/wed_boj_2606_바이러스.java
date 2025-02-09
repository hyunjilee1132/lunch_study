package week02.hyunji;

import java.util.*;

public class wed_boj_2606_바이러스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        int m = sc.nextInt();  
        
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v); 
            graph[v].add(u); 
        }
        
        boolean[] visited = new boolean[n + 1];  
        int cnt = dfs(1, graph, visited);
        
        System.out.println(cnt-1); //1번 컴퓨터를 통해 걸리는 => 1 빼주기 
    }
    
    public static int dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;  
        
        int count = 1;  
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited); //재귀호출 => 값 누적 
            }
        }
        
        return count;  
    }
}

