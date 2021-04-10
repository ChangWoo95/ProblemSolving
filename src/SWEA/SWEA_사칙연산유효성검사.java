package SWEA;
import java.io.*;
import java.util.*;

public class SWEA_사칙연산유효성검사 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t = 1; t<=10; ++t) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;

            for(int i = 0; i<n; ++i) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);

                if(x*2+1<=n) {
                    if(c>='0' && c<='9') flag = false;
                }
                else {
                    if(!(c>='0' && c<='9')) flag = false;
                }
            }
            if(flag) sb.append("#").append(t).append(" ").append(1).append('\n');
            else sb.append("#").append(t).append(" ").append(0).append('\n');
        }
        System.out.println(sb);
    }
}
