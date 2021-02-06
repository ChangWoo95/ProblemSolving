package general;

import java.io.*;
import java.util.*;

public class Boj_1620_나는야포켓몬마스터 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, String> book  = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s;
        for(int i =1; i <= n; i++){
            s = br.readLine();
            book.put(s, String.valueOf(i));
            book.put(String.valueOf(i), s);
        }
        for(int i = 1; i <= m; i++){
            s = br.readLine();
            sb.append(book.get(s)).append("\n");
        }
        System.out.print(sb);
    }
}
