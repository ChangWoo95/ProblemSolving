package programmers;

import java.util.Arrays;

public class Kakao2018_프렌즈4블록 {

    int externM;
    int externN;
    char[][] externBoard;
    boolean[][] visited;

    int answer = 0;

    public int solution(int m, int n, String[] board) {
        externM = m;
        externN = n;
        externBoard = new char[externM][];
        for(int i = 0 ; i < externM; ++i){
            externBoard[i] = board[i].toCharArray();
        }
        visited = new boolean[externM][externN];
        boolean isBombed = false;

        while(!isBombed) {
            init();
            isBombed = playGame(isBombed);
            if(isBombed) {
                bomb();
                moveFriend();
                isBombed = false;
            }
            else break;
        }

        return answer;
    }

    public boolean playGame(boolean isBombed) {
        for(int i = 0; i < externM; ++i) {
            for(int j = 0 ; j < externN; ++j) {
                if(externBoard[i][j] == '0') continue;
                if(isBlocked(i, j)){
                    isBombed = true;
                    visited[i][j] = true;
                    visited[i][j+1] = true;
                    visited[i+1][j] = true;
                    visited[i+1][j+1] = true;
                }
            }
        }
        return isBombed;
    }

    public boolean isBlocked(int x, int y) {
        int rightX = x, rightY = y+1;
        if(!isIn(rightX, rightY) || externBoard[x][y] != externBoard[rightX][rightY]) return false;

        int downX = x + 1, downY = y;
        if(!isIn(downX, downY) || externBoard[x][y] != externBoard[downX][downY]) return false;

        int diagnalX = x + 1, diagnalY = y + 1;
        if(!isIn(diagnalX, diagnalY) || externBoard[x][y] != externBoard[diagnalX][diagnalY]) return false;

        return true;
    }

    public boolean isIn(int x,int y) {
        return x >=0 && x < externM && y>=0 && y < externN;
    }

    public void bomb(){
        for(int i = 0 ; i < externM; ++i) {
            for(int j = 0 ; j < externN; ++j) {
                if(visited[i][j]) {
                    answer+=1;
                    externBoard[i][j] = '0';
                }
            }
        }
    }

    public void init() {
        for(int i = 0 ; i < externM; ++i) {
            Arrays.fill(visited[i], false);
        }
    }

    public void moveFriend() {
        for(int j = externN -1; j >=0; --j) {
            for(int i = externM - 1; i >=0 ; --i) {
                if(externBoard[i][j] != '0') continue;
                swapBlock(i, j);
            }
        }
    }

    public void swapBlock(int x, int y) {
        int tmpX = x-1;
        while(isIn(tmpX, y)) {
            tmpX-=1;
            if( isIn(tmpX, y) && externBoard[tmpX][y] != '0') {
                externBoard[x][y] = externBoard[tmpX][y];
                externBoard[tmpX][y] = '0';
                break;
            }
        }
    }
}
