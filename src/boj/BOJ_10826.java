package boj;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_10826 {

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));
    }

    private static BigInteger fibonacci(int x){
        BigInteger[] d = new BigInteger[10001];

        d[0] = BigInteger.ZERO; d[1] = BigInteger.ONE;

        for(int i = 2; i <= x; i++){
            d[i] = d[i-1].add(d[i-2]);
        }

        return d[x];
    }
}
