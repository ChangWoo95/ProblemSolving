package algoStudy;

import java.io.*;
import java.util.*;

public class Boj_1339_단어수학 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        int n = Integer.parseInt(br.readLine());
        String s;
        List<Integer> placeVal = new ArrayList<>();
        long sum = 0;
        int maxNum = 9;
        for(int i =0; i < n; i++) {
            s = br.readLine();
            for(int j =0; j <s.length(); j++){
                alpha[s.charAt(j) - 'A'] += Math.pow(10, s.length() - j - 1);
            }
        }
        for(int i =0; i< 26; i++){
            if(alpha[i] == 0) continue;
            placeVal.add(alpha[i]);
        }
        Collections.sort(placeVal);
        for(int i = placeVal.size() - 1; i >=0; i-- ){
            sum += (placeVal.get(i) * maxNum--);
        }
        System.out.println(sum);
    }
}
