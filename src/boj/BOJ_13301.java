package boj;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_13301 {
    private static int n;
    private static BigInteger[] tileSize = new BigInteger[81];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        calcTileSize(n);

        if(n == 1){
            System.out.println(4);
            return;
        }

        System.out.println(tileSize[n].multiply(BigInteger.valueOf(4)).add(tileSize[n - 1].multiply(BigInteger.valueOf(2))));
    }

    private static void calcTileSize(int x){
        tileSize[1] = BigInteger.ONE; tileSize[2] = BigInteger.ONE;
        for(int i = 3; i <= x; i++){
            tileSize[i] = tileSize[i - 1].add(tileSize[i - 2]);
        }
    }
}
