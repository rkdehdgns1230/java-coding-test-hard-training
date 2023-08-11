package boj;

import java.io.*;
import java.util.*;

public class BOJ_14284 {

    private static int n, m;
    private static int INF = 5000001;
    private static ArrayList<ArrayList<Point>> v = new ArrayList<>();
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = INF;
        }
        for(int i = 0; i <= n; i++){
            v.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            v.get(a).add(new Point(b, c));
            v.get(b).add(new Point(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        dijkstra(s);

        System.out.println(dp[t]);
    }

    private static void dijkstra(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dp[x] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Point point : v.get(cur)){
                int next = point.y;
                int dis = point.edge;

                if(dp[next] < dis)
                    continue;

                if(dp[next] > dp[cur] + dis){
                    dp[next] = dp[cur] + dis;
                    q.add(next);
                }
            }
        }
    }

    private static class Point{
        int y;
        int edge;

        public Point(int y, int edge){
            this.y = y;
            this.edge = edge;
        }
    }
}
