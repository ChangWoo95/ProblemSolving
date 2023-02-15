import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1972_놀라운문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s != null && s.equals("*")) break;

            if (isSurprising(s)) {
                sb.append(s).append(" is surprising.").append("\n");
            } else {
                sb.append(s).append(" is NOT surprising.").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isSurprising(String s) {

        for (int i = 1; i <= s.length() - 1; ++i) {
            Set<String> stringSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < s.length(); ++j) {
                if (j + i >= s.length()) continue;

                String substring = sb.append(s.charAt(j)).append(s.charAt(j + i)).toString();
                if (stringSet.contains(substring)) {
                    return false;
                }

                stringSet.add(substring);
                sb.setLength(0);
            }
        }
        return true;
    }
}
