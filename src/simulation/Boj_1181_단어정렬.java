package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashSet<String> ss = new HashSet<>();

        for(int i = 0; i < n; i++){
            ss.add(br.readLine());
        }
        List<String> s = new ArrayList<>(ss); //arraylist에 Hashset에 담긴 요소들을 담는 것이 arraylist에서 중복요소를 배제하면서 진행하는 것보다 약 5배 빠름!!

        Collections.sort(s, (o1, o2) -> {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });

        for(String ans : s) {
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
