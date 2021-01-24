package queue;

import java.io.*;
import java.util.*;

public class Boj_3425_고스택 {
    static ArrayList<String> opList = new ArrayList<>(); // 명령어를 받음
    static ArrayList<Long> opNumList = new ArrayList<>(); // NUM명령어 시, 뒤의 숫자를 받음
    static Deque<Long> numList = new LinkedList<>(); // stack 처리에 이용될 deque
    static StringBuilder sb =  new StringBuilder();
    static int idx = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String op;
        long num;

        while(true) {
            st = new StringTokenizer(br.readLine());
            op = st.nextToken();
            if(op.equals("QUIT")) break;
            else if(op.equals("NUM")) {
                opList.add(op);
                opNumList.add(Long.parseLong(st.nextToken()));
            }
            else if(op.equals("END")){ // END가 들어올 경우, 숫자에 대한 프로그램 수행
                num = Long.parseLong(br.readLine());
                for(int i  = 0; i< num; i++){
                    numList.addFirst(Long.parseLong(br.readLine()));
                    execute();
                    numList.clear();
                    idx = 0;
                }
                br.readLine();  // 한 프로그램이 끝날 경우 들어오는 공백 처리
                opList.clear();
                opNumList.clear();
                sb.append("\n");
            } else opList.add(op);
        }
        System.out.print(sb);
    }

    static void execute() {
        long fir, sec, remainder, quotient;
        for(int i = 0; i < opList.size(); i++){
            if(opList.get(i).equals("MUL")) {
                if(lackOfNumbers()) return;
                fir = numList.pollFirst();
                sec = numList.pollFirst();
                sec *= fir;

                if(overflowNumbers(sec)) return;
                numList.addFirst(sec);
            }
            else if(opList.get(i).equals("NUM")) numList.addFirst(opNumList.get(idx++));
            else if(opList.get(i).equals("POP")){
                if(isEmpty()) return;
                numList.removeFirst();
            }
            else if(opList.get(i).equals("INV")) {
                if(isEmpty()) return;
                fir = numList.pollFirst();
                numList.addFirst(-fir);
            }
            else if(opList.get(i).equals("DUP")) {
                if(isEmpty()) return;
                numList.addFirst(numList.peek());
            }
            else if(opList.get(i).equals("SWP")) {
                if(lackOfNumbers()) return;
                fir = numList.pollFirst();
                sec = numList.pollFirst();
                numList.addFirst(fir);
                numList.addFirst(sec);
            }
            else if(opList.get(i).equals("ADD")) {
                if(lackOfNumbers()) return;
                fir = numList.pollFirst();
                sec = numList.pollFirst();
                sec += fir;
                if(overflowNumbers(sec)) return;
                numList.addFirst(sec);
            }
            else if(opList.get(i).equals("SUB")) {
                if(lackOfNumbers()) return;
                fir = numList.pollFirst();
                sec = numList.pollFirst();
                sec -= fir;
                if(overflowNumbers(sec)) return;
                numList.addFirst(sec);
            }
            else if(opList.get(i).equals("DIV")) {
                if(lackOfNumbers()) return;
                fir = numList.pollFirst();
                sec = numList.pollFirst();
                if(fir == 0) {
                    sb.append("ERROR").append("\n");
                    return;
                }
                quotient = Math.abs(sec) / Math.abs(fir);
                if((fir <0 && sec >0) || (fir >0 && sec < 0)) quotient = -quotient;
                numList.addFirst(quotient);

            }
            else if(opList.get(i).equals("MOD")) {
                if(lackOfNumbers()) return;
                fir = numList.pollFirst();
                sec = numList.pollFirst();
                if(fir == 0) {
                    sb.append("ERROR").append("\n");
                    return;
                }
                remainder = Math.abs(sec) % Math.abs(fir);
                if(sec < 0) remainder = -remainder;
                numList.addFirst(remainder);
            }
        }
        if(numList.size() == 1)  sb.append(numList.poll()).append("\n");
        else sb.append("ERROR").append("\n");
    }
    static boolean lackOfNumbers(){ // deque에 수가 2개보다 적을 경우
        if(numList.size() < 2) {
            sb.append("ERROR").append("\n");
            return true;
        }
        return false;
    }
    static boolean overflowNumbers(long num) { // 10^9보다 큰지 작은지 확인
        if(Math.abs(num) > 1000000000 ) {
            sb.append("ERROR").append("\n");
            return true;
        }
        return false;
    }
    static boolean isEmpty(){  // deque가 비어있을 경우
        if(numList.isEmpty()) {
            sb.append("ERROR").append("\n");
            return true;
        }
        return false;
    }
}
