package IM;

import java.io.*;
import java.util.*;

public class Boj_14696_딱지놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] aList, bList;
        for(int t = 0; t< T; t++){
            st= new StringTokenizer(br.readLine());
            aList = new int[5];
            st.nextToken();
            while(st.hasMoreTokens()){
                ++aList[Integer.parseInt(st.nextToken())];
            }
            bList = new int[5];
            st= new StringTokenizer(br.readLine());
            st.nextToken();
            while(st.hasMoreTokens()){
                ++bList[Integer.parseInt(st.nextToken())];
            }
            if(aList[4] != bList[4]) sb.append((aList[4] < bList[4])? 'B' : 'A' ).append("\n");
            else if(aList[3] != bList[3]) sb.append((aList[3] < bList[3])? 'B' : 'A' ).append("\n");
            else if(aList[2] != bList[2]) sb.append((aList[2] < bList[2])? 'B' : 'A' ).append("\n");
            else if(aList[1] != bList[1]) sb.append((aList[1] < bList[1])? 'B' : 'A' ).append("\n");
            else sb.append('D').append("\n");
        }
        System.out.print(sb);
    }
}
