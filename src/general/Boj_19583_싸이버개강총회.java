package general;

import java.io.*;
import java.util.*;

public class Boj_19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] time = new int[3];
        int t = 0, cnt = 0;
        Set<String> set = new HashSet<>();
        Set<String> out = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s, in;
        for(int i = 0; i < 3; i++){
            s = st.nextToken();
            time[i]+= Integer.parseInt(s.substring(0, 2)) * 60;
            time[i] += Integer.parseInt(s.substring(3));
        }
        while((in = br.readLine()) != null && in.length() != 0) {
            st = new StringTokenizer(in);
            s = st.nextToken();
            t = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
            if( t<= time[0]) set.add(st.nextToken());
            else if(time[1] <= t && t<= time[2]) out.add(st.nextToken());
        }
        Iterator<String> ss = out.iterator();
        while(ss.hasNext()){
            if(set.contains(ss.next())) cnt++;
        }
        System.out.println(cnt);
    }
}
