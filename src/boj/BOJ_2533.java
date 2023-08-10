package boj;

import java.io.*;
import java.util.*;

public class BOJ_2533 {
    private static int n;
    private static int MAX = 1000001;
    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static int[][] dp = new int[MAX][2]; // 0: �󸮾����, 1: �Ϲ���

    private static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++){
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < n - 1; i++){
            int a, b;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            // ����� ���� ���� �Է�
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int x){
        visited[x] = true;
        dp[x][0] = 1;

        for(Integer y : tree.get(x)){
            if(visited[y])
                continue;
            
            dfs(y);
            dp[x][1] += dp[y][0]; // x�� �Ϲ��� -> y�� ��� �󸮾����
            dp[x][0] += Math.min(dp[y][1], dp[y][0]); // x�� �󸮾���� -> y�� ��� ����
        }
    }
}
