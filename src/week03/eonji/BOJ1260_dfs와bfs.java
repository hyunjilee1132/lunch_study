package BOJ;

import java.util.*;

public class BOJ1260_dfs와bfs {
    /**
     * dfs와 bfs
     * <a href="https://www.acmicpc.net/problem/1260">...</a>
     */

    static int[][] board;
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] DFSvisited;
    static int[] BFSvisited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 정점의 개수
        int M = sc.nextInt();   // 간선의 개수
        int V = sc.nextInt();   // 시작점

        board = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x][y] = 1;
            board[y][x] = 1;
        }

        DFSvisited = new int[board.length];
        BFSvisited = new int[board.length];


        dfs(V);
        System.out.println();
        bfs(V);

    }

    private static void dfs(int v) {
        stack.push(v);
        DFSvisited[v] = 1;
        System.out.print(stack.pop() + " ");
        for (int i = 0; i < board[v].length; i++) {
            if (board[v][i] == 1 && DFSvisited[i] == 0) {
                dfs(i);
            }
        }

    }

    private static void bfs(int v) {
        if (BFSvisited[v] == 0) {
            queue.add(v);
            System.out.print(queue.poll() + " ");
            BFSvisited[v] = 1;
        }

        for (int i = 1; i < board.length; i++) {
            if (board[v][i] == 1 && BFSvisited[i] == 0) {
                queue.add(i);
                System.out.print(i + " ");
                BFSvisited[i] = 1;
            }
        }


        if (queue.isEmpty()) return;
        bfs(queue.poll());


    }

}
