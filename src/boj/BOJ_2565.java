package boj;

import java.io.*;
import java.util.*;

public class BOJ_2565 {

    private static int n;
    private static int ans = 1;
    private static final int MAX = 501;
    private static int[] arr = new int[MAX];
    private static int[] dp = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a] = b;
            dp[a] = 1;
        }

        // O(N^2) 시간 복잡도
        for(int i = 2; i < MAX; i++){

            for(int j = 1; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.print(n - ans);
    }
}
