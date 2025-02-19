package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1260_dfs와bfs_2 {

    /**
     * dfs와 bfs
     * <a href="https://www.acmicpc.net/problem/1260">...</a>
     */

    static Node[] nodes;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        nodes = new Node[N + 1];
        int idx = 1;    // 노드 숫자랑 인덱스랑 맞춰줄 거임

        for (int i = 1; i <= N; i++) {
            Node node = new Node();
            node.data = i;  // N 숫자만큼 노드 만들어줘
            node.adjacent = new ArrayList<>();  // 노드마다 인접한 숫자 넣어줄 배열 만들어줘
            nodes[idx] = node;  // 노드배열에 넣어서 관리해줄 거야
            idx++;
        }

        for (int i = 0; i < M; i++) {    // 간선 개수만큼 반복
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]); // x번째 노드의 인접 리스트에
            int y = Integer.parseInt(input[1]); // y를 추가할 거야
            nodes[x].adjacent.add(y);
            nodes[y].adjacent.add(x);   // 서로 추가해줘야 함
        }

        /////////////////////////////////////////////

        visited = new int[nodes.length];
        dfs(V);
        System.out.println();

        visited = new int[nodes.length];
        bfs(V);
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new int[nodes.length];
        queue.add(v);
        visited[v] = 1; // 시작노드 방문체크 해주고

        while (!queue.isEmpty()) {    // queue에 뭐라도 있는 동안 반복
            int cur = queue.poll(); // 일단 나를 꺼내주고
            System.out.print(cur + " ");

            Collections.sort(nodes[cur].adjacent);  // 숫자가 작은 노드부터 방문해야 하므로 adjacent 정렬해줌

            for (int next : nodes[cur].adjacent) {   // 나한테 인접한 녀석들 중
                if (visited[next] != 1) {    // 방문한 적 없는 애만
                    queue.add(next);    // queue에 넣어주고
                    visited[next] = 1;  // 방문 체크해줘
                }
            }
        }   // 한 번 끝나면 또 cur = queue.poll()로 돌아가서 얘를 시작노드로 삼아 반복해줄 거야

        System.out.println();
    }

    private static void dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        int cur = v;
        stack.push(v);
        visited[v] = 1;
        System.out.print(stack.pop() + " ");

        Collections.sort(nodes[cur].adjacent);

        for (int next : nodes[cur].adjacent) {
            if(visited[next] != 1)
                dfs(next);
        }

//        while (!stack.isEmpty()){
//            cur = stack.pop();
//            System.out.print(cur + " ");
//
//            Collections.sort(nodes[cur].adjacent, Collections.reverseOrder());
////            Collections.sort(nodes[cur].adjacent, Collections.reverseOrder());
////            for(int next : nodes[cur].adjacent){
//
//            for (int i = nodes[cur].adjacent.size()-1 ; i>=0 ; i--) {  // 인접한 애들 넣어주고 방문 체크
//                int next = nodes[cur].adjacent.get(i);
//                if (visited[next] != 1) {
//                    stack.push(next);
//                    visited[next] = 1;
//                }
//            }
//       }

    }


    public static class Node {
        int data;
        ArrayList<Integer> adjacent;
    }
}



