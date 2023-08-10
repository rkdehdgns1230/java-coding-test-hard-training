package boj;

import java.util.*;
import java.io.*;

public class BOJ_9084 {

    private static int t, n, m;
    private static int coins[];
    private static int d[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());

            dp();
        }
    }

    private static void dp(){
        d = new int[m + 1];
        d[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = coins[i]; j <= m; j++){
                d[j] += d[j - coins[i]];
            }
        }
        System.out.println(d[m]);
    }
}