package IM;

import java.io.*;
import java.util.*;

public class Boj_17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        String s = br.readLine();
        boolean flag = false;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '<') {
                if(tmp.length() != 0) sb.append(tmp.reverse());
                tmp.delete(0, tmp.length());
                flag = true;
                tmp.append(ch);
            } else if (ch == '>') {
                flag = false;
                tmp.append(ch);
                sb.append(tmp);
                tmp.delete(0, tmp.length());
            } else if (ch == ' ') {
                if (!flag) {
                    sb.append(tmp.reverse());
                    tmp.delete(0, tmp.length());
                    sb.append(ch);
                } else tmp.append(ch);
            } else tmp.append(ch);
        }
        if(tmp.length() != 0) sb.append(tmp.reverse());
        System.out.print(sb);
    }
}
