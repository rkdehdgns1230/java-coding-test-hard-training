package boj;

import java.io.*;
import java.util.*;

public class BOJ_2587 {
    private static final int n = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            list.add(num); // auto boxing
            sum += num;
        }

        Collections.sort(list, Comparator.comparingInt(a -> a));

        System.out.println(sum / 5);
        System.out.println(list.get(2));
    }
}
