package IM;

import java.io.*;
import java.util.*;

public class Boj_2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> map = new HashSet<>();
        map.add("c="); map.add("c-");
        map.add("dz="); map.add("d-");
        map.add("lj");map.add("nj");
        map.add("s=");map.add("z=");
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int cnt = 0; char ch;
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            if(ch == 'c' || ch == '=' || ch == '-' || ch == 'd' || ch == 'z' || ch == 'l' || ch == 'j' || ch == 'n' || ch == 's') {
                if(map.contains(sb.toString())){
                    ++cnt;
                    sb.delete(0, sb.length());
                } else {
                    if(sb.length() == 3) {
                        cnt+=1;
                        sb.delete(0, 1);
                    }
                    if(map.contains(sb.toString())){
                        ++cnt;
                        sb.delete(0,sb.length());
                    }
                }
                sb.append(ch);
            } else ++cnt;
        }
        if(sb.length() != 0){
            if(map.contains(sb.toString())) ++cnt;
            else cnt += sb.length();
        }
        System.out.println(cnt);
    }
}
