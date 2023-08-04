package softeer;

import java.io.*;
import java.util.*;

public class 택배_마스터_광우 {
    private static final int MAX = 11;
    private static final int MAX_CARRIAGE = 50;
    private static final int MAX_WORK_CNT = 50;
    private static int minResult = MAX_CARRIAGE * MAX_WORK_CNT;

    private static int[] arr = new int[MAX];
    private static int[] permutation = new int[MAX];

    private static int n, m, k;


    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(new boolean[n], 0);

        System.out.println(minResult);
    }

    private static void dfs(boolean[] visited, int cnt) {
        if(cnt == n){
            int totalCarriage = 0;
            int idx = 0;

            for(int i = 0; i < k; i++){
                int carriage = 0;

                while(carriage + permutation[idx] <= m) {
                    carriage += permutation[idx++];
                    idx %= n;
                }
                totalCarriage += carriage;

                if(totalCarriage > minResult)
                    return;
            }

            minResult = Math.min(minResult, totalCarriage);
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            permutation[cnt] = arr[i];

            dfs(visited, cnt + 1);
            visited[i] = false;
        }

        return;
    }
}
