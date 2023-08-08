package boj;

import java.io.*;
import java.util.*;

public class BOJ_2580 {

    private static final int N = 9;

    private static int map[][] = new int[N][N];

    // 3개의 10 size check boolean array 필요
    private static boolean boxCheck[][] = new boolean[10][10];
    private static boolean rowCheck[][] = new boolean[10][10];
    private static boolean colCheck[][] = new boolean[10][10];
    private static ArrayList<Point> zeroPointList = new ArrayList<>();

    private static boolean isPrint = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    // 0인 포인트를 기억해서 backtracking 돌려야 한다.
                    zeroPointList.add(new Point(i, j));
                    continue;
                }

                rowCheck[i][map[i][j]] = true;
                colCheck[j][map[i][j]] = true;
                boxCheck[calculateBoxNum(i, j)][map[i][j]] = true;
            }
        }
        solve(0);
        
    }

    private static void solve(int idx){
        if(isPrint)
            return;

        if(idx == zeroPointList.size()){
            if(!check())
                return;

            // 스도쿠 완성된 경우에만 출력하도록 한다.
            print();
            isPrint = true;
            return;
        }

        Point cur = zeroPointList.get(idx);

        for(int i = 1; i <= 9; i++) {
            int boxIdx = calculateBoxNum(cur.x, cur.y);
            if(!rowCheck[cur.x][i] && !colCheck[cur.y][i] && !boxCheck[boxIdx][i]) {
                rowCheck[cur.x][i] = true;
                colCheck[cur.y][i] = true;
                boxCheck[boxIdx][i] = true;

                map[cur.x][cur.y] = i;
                solve(idx + 1);

                rowCheck[cur.x][i] = false;
                colCheck[cur.y][i] = false;
                boxCheck[boxIdx][i] = false;
            }
        }
    }

    private static boolean check(){
        for(int i = 0; i < N; i++){
            for(int j = 1; j <= 9; j++){
                // 스도쿠 풀렸는지 확인
                if(!rowCheck[i][j] || !colCheck[i][j] || !boxCheck[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static int calculateBoxNum(int x, int y){
        return ((x / 3) * 3 + (y / 3));
    }

    private static void print(){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
