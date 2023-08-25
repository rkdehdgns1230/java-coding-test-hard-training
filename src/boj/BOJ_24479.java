package boj;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_24479 {
    private static int n, m, r; // 정점의 수, 간선의 수, 시작 정점
    private static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    private static int[] visited = new int[100001];
    private static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++){
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }
        visited[r] = order++;
        dfs(r);

        for(int i = 1; i <= n; i++){
            System.out.println(visited[i]);
        }
    }

    private static void dfs(int x){
        Collections.sort(map.get(x));

        for(int i = 0; i < map.get(x).size(); i++){
            int y = map.get(x).get(i);

            if(visited[y] != 0)
                continue;
            visited[y] = order++;
            dfs(y);
        }
    }
}
