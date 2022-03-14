package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14713_앵무새 {
    public static int len = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<String>[] qArr = new Queue[n];

        for(int i = 0 ; i < n; ++i) {
            qArr[i] = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                qArr[i].add(st.nextToken());
                ++len;
            }
        }

        String[] phrase = br.readLine().split(" ");
        if(isPossible(qArr, phrase)) System.out.println("Possible");
        else System.out.println("Impossible");
    }

    public static boolean isPossible(Queue<String>[] qArr, String[] phrase) {
        for(int i = 0 ; i < phrase.length; ++i) {
            String str = phrase[i];
            boolean flag = false;

            for(int j = 0 ; j <qArr.length; ++j) {
                if(qArr[j].isEmpty()) continue;

                if(qArr[j].peek().equals(str)) {
                    qArr[j].poll();
                    flag = true;
                    --len;
                    break;
                }
            }
            if(!flag) return false;
        }

        if(len != 0) return false;
        else return true;

    }
}
