package stringProblem;

import java.io.*;
import java.util.*;

public class Boj_3613_javavsC {
    static String s;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        sb.append(s);
        sb2.append(s);

        if(s.contains("_")) {
            convertJava();
            System.out.print(sb);
        }
        else {
            convertCplus();
            System.out.print(sb2);
        }
    }
    static void convertJava(){ // C++ -> java
        if(sb.charAt(sb.length()-1) == '_' || sb.charAt(0) == '_') {
            System.out.println("Error!");
            System.exit(0);
        }
        for(int i =0; i <sb.length(); i++){
            if(sb.charAt(i) == '_') {
                sb.delete(i, i + 1);
                if(sb.charAt(i) == '_' || Character.isUpperCase(sb.charAt(i))){
                    System.out.println("Error!");
                    System.exit(0);
                }
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            }
            else if(Character.isUpperCase(sb.charAt(i))){
                System.out.println("Error!");
                System.exit(0);
            }
        }
    }
    static void convertCplus(){ // java -> C++
        if(Character.isUpperCase(sb2.charAt(0))){
            System.out.println("Error!");
            System.exit(0);
        }
        for(int i =0; i < sb2.length(); i++){
            if(Character.isUpperCase(sb2.charAt(i)) ) {
                sb2.setCharAt(i, Character.toLowerCase(sb2.charAt(i)));
                sb2.insert(i, '_');
                i += 1;
            }
        }
    }
}
