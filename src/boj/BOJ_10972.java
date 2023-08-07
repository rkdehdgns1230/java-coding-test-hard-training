package boj;

import java.io.*;
import java.util.*;

public class BOJ_10972 {

    private static int N;
    private static final int MAX = 10001;
    private static int arr[] = new int[MAX];
    private static int res[] = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve();
    }

    private static void solve(){
        int i, j;
        for(i = 0; i < N; i++)
            res[i] = arr[i];
        
        // A[i - 1] < A[i] 마지막 케이스 탐색
        int idx = -1;
        for(i = N - 1; i >= 1; i--){
            if(arr[i - 1] < arr[i]){
                idx = i - 1;
                break;
            }
        }
        if(idx == -1){
            System.out.println(-1);
            return;
        }

        // A[i - 1] <= A[j] && j > i - 1 인 것 탐색
        for(j = N - 1; j > idx; j--){
            if(arr[idx] <= arr[j]){
                break;
            }
        }

        // A[i - 1] <-> A[j]
        res[idx] = arr[j];
        res[j] = arr[idx];

        // A[i ~ N-1] 반대로 뒤집기
        i = idx + 1;
        j = N - 1;
        while(i < j){
            int tmp = res[i];
            res[i] = res[j];
            res[j] = tmp;
            i++; j--;
        }

        for(i = 0; i < N; i++){
            System.out.print(res[i] + " ");
        }
    }
}
