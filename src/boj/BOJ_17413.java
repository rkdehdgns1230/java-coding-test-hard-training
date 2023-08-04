package boj;

import java.io.*;
import java.util.*;

public class BOJ_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        StringBuffer sb = new StringBuffer();
        StringBuffer resultSb = new StringBuffer();

        for(int i = 0; i < inputString.length(); i++){
            if(inputString.charAt(i) == '<'){
                if(sb.length() != 0) {
                    resultSb.append(sb.reverse());
                    sb = new StringBuffer();
                }

                while(inputString.charAt(i) != '>') {
                    sb.append(inputString.charAt(i));
                    i++;
                }
                resultSb.append(sb);
                resultSb.append('>');
                sb = new StringBuffer();
                continue;
            }

            // 띄어쓰기 이전까지는 반대로 넣어줘야 한다.
            if(inputString.charAt(i) == ' '){
                resultSb.append(sb.reverse());
                resultSb.append(' ');
                sb = new StringBuffer();
                continue;
            }

            sb.append(inputString.charAt(i));
        }
        if(sb.length() != 0)
            resultSb.append(sb.reverse());

        System.out.print(resultSb);
    }
}
