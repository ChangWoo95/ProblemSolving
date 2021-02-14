package general;

import java.io.*;
import java.util.*;

public class Boj_2002_추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        Map<String, Integer> in = new HashMap<>();
        String[] out = new String[n];
        for(int i = 0; i < n; i++){
            in.put(br.readLine(), i);
        }
        for(int i = 0; i < n; i++){
            out[i] = br.readLine();
        }

        for(int i = 0; i <n; i++){
            for(int j = i+1; j < n; j++){
                if(in.get(out[i]) > in.get(out[j]) ){
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
