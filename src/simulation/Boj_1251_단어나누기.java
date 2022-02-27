package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1251_단어나누기 {

    public static String orgString;
    public static String answer = "";
    public static int len = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        orgString = br.readLine();
        len = orgString.length();

        for(int i = 1; i < len - 1; ++i) {
            for(int j = i+1; j < len; ++j) {
                String result = makeString(i, j);
                if(answer.length() == 0 || answer.compareTo(result) > 0) answer = result;
            }
        }
        System.out.println(answer);
    }

    public static String makeString(int start, int end) {
        StringBuilder ret = new StringBuilder();
        ret.append(reverse(orgString.substring(0, start)));
        ret.append(reverse(orgString.substring(start, end)));
        ret.append(reverse(orgString.substring(end, len)));
        return ret.toString();
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
