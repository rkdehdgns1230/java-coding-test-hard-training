package softeer;

import java.util.*;
import java.io.*;

public class 사물인식_최소면적_산출_프로그램 {
    private static int K, N;
    private static List<List<Point>> sites;
    private static int minSize = Integer.MAX_VALUE;
    private static Point pickSites[];

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == 1 && K == 1){
            System.out.println(0);
            return;
        }

        sites = new ArrayList<>();
        for(int i = 0; i < K; i++){
            sites.add(new ArrayList<Point>());
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            sites.get(color - 1).add(new Point(x, y));
        }

        pickSites = new Point[K];

        pick(0, 1000, -1000, 1000, -1000);
        System.out.println(minSize);
    }

    private static void pick(int cnt, int startX, int endX, int startY, int endY){
        if(cnt == K){
            minSize = Math.min(minSize, (endX - startX) * (endY - startY));
            return;
        }

        for(int i = 0; i < sites.get(cnt).size(); i++){
            pickSites[cnt] = sites.get(cnt).get(i);

            int tmpStartX = Math.min(startX, pickSites[cnt].x);
            int tmpEndX = Math.max(endX, pickSites[cnt].x);

            int tmpStartY = Math.min(startY, pickSites[cnt].y);
            int tmpEndY = Math.max(endY, pickSites[cnt].y);

            if((tmpEndX - tmpStartX) * (tmpEndY - tmpStartY) >= minSize)
                continue;

            pick(cnt + 1, tmpStartX, tmpEndX, tmpStartY, tmpEndY);
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
