package trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_9202_Boggle {

    static class Trie{
        TrieNode rootNode;
        Trie(){
            rootNode = new TrieNode();
        }

        void insert(String word){
            TrieNode tNode = this.rootNode;
            for(int i = 0 ; i < word.length(); ++i){
                tNode = tNode.getChildNodes().computeIfAbsent(word.charAt(i), c-> new TrieNode());
            }
            tNode.setLastChar(true);
        }

        boolean contains(String word){ // 해당 단어의 문자가 map에 존재하는지 확인, 또한 해당 단어가 있는지 확인하기 위한 flag 반환
            TrieNode tNode = this.rootNode;
            for(int i = 0 ; i < word.length(); ++i){
                char ch = word.charAt(i);
                TrieNode node = tNode.getChildNodes().get(ch);
                if(node == null) return false;
                tNode = node;
            }
            return tNode.isLastChar();
        }

    }
    static class TrieNode{
        Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isLastCh;
        Map<Character, TrieNode> getChildNodes(){
            return childNodes;
        }
        boolean isLastChar(){
            return isLastCh;
        }
        void setLastChar(boolean isLastCh){
            this.isLastCh = isLastCh;
        }
    }
    static Trie tri;
    static char[][] map;
    static int[][] d = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
    static boolean[][] visited = new boolean[4][4];
    static int findWordCnt, maxScore;
    static String longWord;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tri = new Trie();
        for(int i = 0 ; i <n; ++i){
            tri.insert(br.readLine());
        }
        br.readLine();
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; ++t){
            maxScore = 0;
            findWordCnt = 0;
            longWord = "";
            set = new HashSet<>();
            map = new char[4][];

            for(int i = 0 ; i < 4; ++i){
                map[i] = br.readLine().toCharArray();
            }

            for(int i = 0 ; i < 4; ++i){
                for(int j = 0; j < 4; ++j){
                    visited[i][j] = true;
                    dfs(i, j, 1, String.valueOf(map[i][j]) );
                    visited[i][j] = false;
                }
            }

            if(t != T-1) br.readLine();
            sb.append(maxScore).append(" ").append(longWord).append(" ").append(findWordCnt).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y, int depth, String s){
        if(tri.contains(s) ) {
            if( !set.contains(s) ) {
                ++findWordCnt;
                int len = s.length();
                if(len == 3 || len == 4) maxScore += 1;
                else if(len == 5) maxScore += 2;
                else if(len == 6) maxScore += 3;
                else if(len == 7) maxScore += 5;
                else if(len == 8) maxScore += 11;

                set.add(s);
                if(len >  longWord.length()) longWord = s;
                else if(len == longWord.length() &&  s.compareTo(longWord) < 0) longWord = s;
            }
        }

        if(depth == 8) return ;

        for(int i = 0 ; i < 8; ++i){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if( nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
            if(!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, s + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }

    }
}
