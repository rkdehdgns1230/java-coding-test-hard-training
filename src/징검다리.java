import java.util.*;

public class 징검다리 {
    private static final int MAX_N = 3001;
    private static int[] arr = new int[MAX_N];
    private static int[] d = new int[MAX_N];

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        dp(n);

        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, d[i]);
        }
        System.out.println(max);

    }

    private static void dp(int n){
        for(int i = 0; i < n; i++){
            d[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }
    }
}
