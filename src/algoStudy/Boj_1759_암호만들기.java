package algoStudy;

import java.io.*;
import java.util.*;

/**
* @since 2021-02-02
* @author ChangWoo95
* @see https://www.acmicpc.net/problem/1759
* @time 128 ms
* @mem 14708 KB
* @caution
*/

public class Boj_1759_암호만들기 {
    static int m, n;
    static char[] word, output;
    static Set<Character> ch = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        word = new char[n];
        output = new char[m];
        ch.add('a');
        ch.add('e');
        ch.add('i');
        ch.add('o');
        ch.add('u');

        for(int i =0; i <n; i++)
            word[i] = st.nextToken().charAt(0);
        Arrays.sort(word);

        crypt(0, 0);
        System.out.print(sb);
    }
    static void crypt(int depth, int start){
        if(depth == m) {
            if(!isCorrect()) return;

            sb.append(String.valueOf(output));
            sb.append("\n");
            return;
        }
        for(int i = start; i < n; i++){
            output[depth] = word[i];
            crypt(depth+1, i+1);
        }
    }
    static boolean isCorrect(){
        int moth = 0;
        int fath = 0;

        for(int i = 0; i < m; i++){
            if(ch.contains(output[i])) moth++;
            else fath++;
        }
        return moth >=1 && fath >=2;
    }
}
