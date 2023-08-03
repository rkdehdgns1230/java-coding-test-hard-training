package softeer;

import java.util.Scanner;

public class 지도_자동_구축 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int iter = 2;
        for(int i = 1; i <= n; i++){
            iter = iter + (iter - 1);
        }

        System.out.println(iter * iter);
    }
}
