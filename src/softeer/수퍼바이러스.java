package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수퍼바이러스 {
    private static final int MOD = 1000000007;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long k = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        n *= 10;

        long res = solve(p, n) * k;
        res %= MOD;

        System.out.println(res);
    }

    private static long solve(long p, long n){
        if(n == 1)
            return p;

        long res = solve(p, n / 2);
        if(n % 2 == 0){
            return (res * res) % MOD;
        }
        else{
            res *= res;
            res %= MOD;
            return (res * p) % MOD;
        }
    }
}
