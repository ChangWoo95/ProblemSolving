package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;



public class Boj_S1_5021_왕위계승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String king = br.readLine();
        String[] successor = new String[m];
        int[] relation = new int[m];
        int maxRelation = Integer.MIN_VALUE;
        int idx = 0;
        Map<String, String> family = new HashMap<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent1 = st.nextToken();
            String parent2 = st.nextToken();
            family.put(parent1, child);
            family.put(parent2, child);
        }

        for(int i = 0; i < m; i++){
            successor[i] = br.readLine();
            relation[i] = findMyRelation(family, king, successor[i]);
            if(maxRelation < relation[i]) maxRelation = relation[i];
            idx = i;
        }
        System.out.println(successor[idx]);
    }

    public static int findMyRelation(Map<String, String> f, String st, String ed){
        int cnt = 0;
        while(st.equals(ed)){
            st = f.get(st);
            cnt++;
        }
        return cnt;
    }
}
