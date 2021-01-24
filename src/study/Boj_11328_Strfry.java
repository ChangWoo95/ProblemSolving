package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11328_Strfry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        String s1, s2;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            s1 = st.nextToken();
            s2 = st.nextToken();
            if(s1.equals(s2)) { // 두 문자열이 동일 할 경우
                sb.append("Possible").append("\n");
                continue;
            }
            else if(s1.length() != s2.length()) { // 길이가 다를 경우(재배치 해도 못 만든다)
                sb.append("Impossible").append("\n");
                continue;
            }

            alpha1 = countingAlpha(s1, alpha1);
            alpha2 = countingAlpha(s2, alpha2);
            if(isMatched(alpha1, alpha2)) sb.append("Possible").append("\n");
            else sb.append("Impossible").append("\n");

            Arrays.fill(alpha1,0);
            Arrays.fill(alpha2, 0);
        }
        System.out.print(sb);
    }
    static int[] countingAlpha(String s , int[] arr) {
        for(int i = 0; i< s.length(); i++){
            arr[s.charAt(i)- 97]++;
        }
        return arr;
    }

    static boolean isMatched(int[] alpha1, int[] alpha2){
        for(int i =0; i< alpha1.length; i++){
            if(alpha1[i] != alpha2[i]) return false;
        }
        return true;
    }
}
