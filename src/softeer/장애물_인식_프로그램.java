package softeer;

import java.util.*;

public class 장애물_인식_프로그램 {
    private static final int MAX_N = 26;
    private static boolean[][] visited = new boolean[MAX_N][MAX_N];
    private static int n;
    private static String[] map = new String[MAX_N];
    private static LinkedList<Integer> resultList = new LinkedList<>();

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int i, j;
        n = in.nextInt();
        in.nextLine();

        for(i = 0; i < n; i++){
            map[i] = in.nextLine();
        }

        for(i = 0; i < n; i++){
            for(j = 0; j < map[i].length(); j++){
                if(map[i].charAt(j) == '1' && !visited[i][j])
                    resultList.add(BFS(i, j));
            }
        }

        Collections.sort(resultList, Comparator.comparingInt(a -> a));
        System.out.println(resultList.size());
        for(Integer member : resultList){
            System.out.println(member);
        }
    }

    private static int BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int res = 0;

        q.add(new Point(x, y));
        visited[x][y] = true;

        while(q.size() != 0){
            Point cur = q.poll();
            res++;

            for(int i = 0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(!check(nextX, nextY) || visited[nextX][nextY] || map[nextX].charAt(nextY) == '0')
                    continue;

                visited[nextX][nextY] = true;

                q.add(new Point(nextX, nextY));
            }
        }
        return res;
    }

    private static boolean check(int x, int y){
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
