package boj;

import java.util.*;
import java.io.*;

public class BOJ_11060 {

    private static int n;
    private static int[] miro = new int [1001];
    private static int[] d;
    private static int INF = 1001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        d = new int[n];
        for(int i = 0; i < n; i++){
            d[i] = INF;
        }
        d[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            miro[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            for(int j = 1; j <= miro[i]; j++){
                if(i + j >= n)
                    continue;
                d[i + j] = Math.min(d[i + j], d[i] + 1);
            }
        }

        if(d[n - 1] == INF){
            System.out.println(-1);
            return;
        }
        System.out.println(d[n - 1]);
    }
}
