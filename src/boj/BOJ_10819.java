package boj;

import java.io.*;
import java.util.*;

public class BOJ_10819 {
    private static int n;
    private static int arr[] = new int[9];
    private static int permutation[] = new int[9];
    private static int maxResult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backTracking(0, new boolean[n]);

        System.out.println(maxResult);
    }

    private static void backTracking(int cnt, boolean visited[]){
        if(cnt == n){
            int res = 0;
            for(int i = 1; i < n; i++){
                res += Math.abs(permutation[i - 1] - permutation[i]);
            }
            maxResult = Math.max(res, maxResult);
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            permutation[cnt] = arr[i];
            backTracking(cnt + 1, visited);
            visited[i] = false;
        }
        return;
    }
}
