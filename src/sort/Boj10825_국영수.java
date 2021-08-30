package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10825_국영수 {
    public static class Student {
        String name;
        int  koreanScore;
        int englishScore;
        int mathScore;

        Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }
    }

    public static int n;
    public static Student[] students;


    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(students, (x1,x2) -> {
            if(x1.koreanScore != x2.koreanScore) return Integer.compare(x2.koreanScore, x1.koreanScore);
            else if(x1.englishScore != x2.englishScore) return Integer.compare(x1.englishScore,x2.englishScore);
            else if(x1.mathScore != x2.mathScore) return Integer.compare(x2.mathScore, x1.mathScore);
            else return x1.name.compareTo(x2.name);
        });
        StringBuilder sb = new StringBuilder();
        for(Student student : students) {
            sb.append(student.name).append("\n");
        }
        System.out.println(sb);

    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        students = new Student[n];

        for(int i = 0 ; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int koreanScore = Integer.parseInt(st.nextToken());
            int englishScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, koreanScore, englishScore, mathScore);
        }

        return;
    }



}

