package general;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Boj_1436_영화감독슘 {
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        int num = 665;
        int n = Integer.parseInt(br.readLine());
        while (true) {
            if (list.size() == n) break;
            num += 1;
            sb.append(num);
            if(serial(sb)) list.add(num);
            sb.delete(0, sb.length());
        }
        System.out.println(list.get(n-1));
    }
    static boolean serial(StringBuilder sb) {
        for(int i =0; i <=sb.length()-3; i++ ){
            if(sb.charAt(i) == '6' && sb.charAt(i+ 1) == '6' && sb.charAt(i + 2) == '6') return true;
        }
        return false;
    }
}
