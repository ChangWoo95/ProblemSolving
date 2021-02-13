package general;

import java.io.*;

public class Boj_11718_그대로출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while( (s = br.readLine()) != null && s.length() != 0 ){
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
