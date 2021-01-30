package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_9536_여우는어떻게울지 {
    static List<String> list = new ArrayList<>();
    static List<String> removeList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String s;


        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            list.clear();
            removeList.clear();

            while(st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            while(true) {
                s = br.readLine();
                if(s.equals("what does the fox say?")) break;
                st = new StringTokenizer(s);
                for(int  i =0; i < 2; i++)
                    st.nextToken();
                removeList.add(st.nextToken());
            }
            list.removeAll(removeList);
            for(int i = 0; i < list.size(); i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
