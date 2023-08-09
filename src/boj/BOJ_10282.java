package boj;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_10282 {
    private static int t;
    private static int n, d, c;
    private static int INF = (int) 1e9;
    private static ArrayList<ArrayList<Edge>> map;
    private static StringBuilder strAns = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        while(t != 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                map.add(new ArrayList<>());
            }

            for(int i = 0; i < d; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                map.get(y).add(new Edge(x, cost));
            }
            dijkstra();
            t--;
        }
        System.out.println(strAns);
    }

    private static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] d = new int[n + 1];
        for(int i = 1; i <= n; i++){
            if(i == c){
                d[i] = 0;
                continue;
            }
            d[i] = INF;
        }

        pq.add(new Edge(c, 0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int cur = e.y;
            int dis = e.cost;

            if(d[cur] < dis){
                continue;
            }

            for(int i = 0; i < map.get(cur).size(); i++){
                int nextDis = d[cur] + map.get(cur).get(i).cost;
                int next = map.get(cur).get(i).y;

                if(nextDis < d[next]) {
                    d[next] = nextDis;
                    pq.add(new Edge(next, nextDis));
                }
            }
        }

        int cnt = 0;
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(d[i] != INF) {
                cnt++;
                ans = Math.max(ans, d[i]);
            }
        }
        strAns.append(cnt + " " + ans + "\n");
    }
    private static class Edge implements Comparable<Edge>{
        int y;
        int cost;

        public Edge(int y, int cost){
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
