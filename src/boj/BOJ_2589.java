package boj;

import java.util.*;
import java.io.*;

public class BOJ_2589 {
    private static final int MAX = 51;
    private static int n, m;
    private static int ans = 0;
    private static String[] map = new String[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            map[i] = br.readLine();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i].charAt(j) == 'L'){
                    BFS(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    private static void BFS(int x, int y){
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        boolean[][] visited = new boolean[MAX][MAX];
        visited[x][y] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(!check(nextX, nextY) || visited[nextX][nextY] || map[nextX].charAt(nextY) != 'L')
                    continue;

                visited[nextX][nextY] = true;
                Point next = new Point(nextX, nextY);
                next.distance = cur.distance + 1;

                ans = Math.max(ans, next.distance);
                q.add(next);
            }
        }
    }

    private static boolean check(int x, int y){
        return (0 <= x && x < n && 0 <= y && y < m);
    }

    private static class Point{
        int x;
        int y;
        int distance;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
