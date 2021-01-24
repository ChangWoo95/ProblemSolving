package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_S5_1380_귀걸이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String[] girls = new String[n];
            String[] earingList = new String[n];
            for(int i = 0; i< earingList.length; i++) {
                earingList[i] ="";
            }
            for(int i= 0 ;i < n; i++){
                girls[i] = br.readLine();
            }
            for(int i = 0; i< 2*n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String num = st.nextToken();
                String valid = st.nextToken();
                earingList[Integer.parseInt(num) - 1] += valid;
            }
            for(int i = 0; i< earingList.length; i++){
                if(earingList[i].length() == 1) {
                    System.out.printf("%d %s\n", cnt++, girls[i]);
                }
            }
        }
    }
}
