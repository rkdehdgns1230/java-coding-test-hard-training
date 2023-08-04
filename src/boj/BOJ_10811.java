package boj;

import java.util.*;
import java.io.*;

public class BOJ_10811 {
    private static int n, m;
    private static final int MAX = 101;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init(n);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            revertArray(a, b);
        }

        for(int i = 1; i <= n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void init(int n){
        arr = new int[n + 1];

        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }
    }

    private static void revertArray(int a, int b){
        int[] tmpArray = new int[n + 1];

        for(int i = 1; i <= n; i++){
            tmpArray[i] = arr[i];
        }

        for(int i = a; i <= b; i++){

            tmpArray[i] = arr[b - (i - a)];
        }

        for(int i = 1; i <=n; i++){
            arr[i] = tmpArray[i];
        }
    }
}
