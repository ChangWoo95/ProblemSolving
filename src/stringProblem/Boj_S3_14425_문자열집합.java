package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_S3_14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> wordList = new ArrayList<>();
        int ans = 0;

        for(int i = 0; i < n; i++){
            wordList.add(br.readLine());
        }

        for(int i = 0; i < m; i++){
            String validWord = br.readLine();
            if(wordList.contains(validWord)) ans++;
        }
        System.out.println(ans);
    }
}
