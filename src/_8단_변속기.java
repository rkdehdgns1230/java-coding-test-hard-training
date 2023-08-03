import java.util.*;

public class _8단_변속기 {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i < 8; i++){
            int tmp = in.nextInt();
            list.add(tmp);
        }
        int prev = list.get(0);
        boolean isAscending = true;
        for(int i = 1; i < list.size(); i++){
            if(prev <= list.get(i)){
                prev = list.get(i);
                continue;
            }
            else{
                isAscending = false;
                break;
            }
        }
        if(isAscending){
            System.out.println("ascending");
            return;
        }

        prev = list.get(0);
        boolean isDescending = true;
        for(int i = 1; i < list.size(); i++){
            if(prev >= list.get(i)){
                prev = list.get(i);
                continue;
            }
            else{
                isDescending = false;
                break;
            }
        }
        if(isDescending){
            System.out.println("descending");
            return;
        }

        System.out.println("mixed");
        return;
    }
}
