package stringProblem;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Boj_4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        String s;
        int cnt = 0;

        while( (s = br.readLine()) != null && s.length() != 0) {
            if(map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
            ++cnt;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", (double) entry.getValue() /cnt * 100)).append("\n");
        }
        System.out.print(sb);
    }
}
