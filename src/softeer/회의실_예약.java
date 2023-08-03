package softeer;

import java.util.*;

public class 회의실_예약 {

    private static final int MAX_MEETING_ROOM = 51;
    private static final int MAX_INPUT_CNT = 101;

    private static Map<String, Integer> meeting_room_map = new HashMap<>();

    public static void main(String args[])
    {
        int[][] meeting_room_time_table = new int[MAX_MEETING_ROOM][19];
        int i, j, k;

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        for(i = 0; i < n; i++){
            String meeting_room_name = in.nextLine();
            meeting_room_map.put(meeting_room_name, i);
        }

        for(i = 0; i < m; i++){
            String name = in.next();
            int start_time = in.nextInt();
            int end_time = in.nextInt();

            // map에서 조회
            int idx = meeting_room_map.get(name);

            for(j = start_time; j < end_time; j++)
                meeting_room_time_table[idx][j] = 1;
        }

        int interval_cnt = 0;

        for(i = 0; i < n; i++){
            boolean isOff = false;
            int interval_start_point, interval_end_point;

            for(j = 9; j <= 18; j++){
                StringBuilder strBuilder = new StringBuilder();
                if(meeting_room_time_table[i][j] == 0){
                    strBuilder.append(j);
                    strBuilder.append('-');

                    while(meeting_room_time_table[i][j] == 0)
                        j++;

                    strBuilder.append(j);
                }

            }
        }
    }
}
