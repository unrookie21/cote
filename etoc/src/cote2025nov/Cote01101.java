package cote2025nov;

import java.util.*;

public class Cote01101 {

    static class Solution {

        public List<String> genBoard(int n , String[][] board){

            List<String> solution = new ArrayList<>();
            for (String[] row : board){
                StringBuilder sb = new StringBuilder();
                for (String str : row){
                    sb.append(str);
                }
                solution.add(sb.toString());
            }
            return solution;
        }

        public void dfs(int row, int n, String[][] board, List<List<String>> answer){

            if (row == n){
                answer.add(genBoard(n, board));
                return;
            }

            // col 탐색
            for (int col = 0; col < n; col++){
                // 퀸을 배치할 수 있는지 확인
                if (canReplace(row, col, board, n)){
                    // 배치할 수 있으면, 배치하기.
                    board[row][col] = "Q";
                    // 다음 단계로 탐색 진행
                    dfs(row + 1, n, board, answer);
                    // 탐색하고 돌아왔을때, Q 배치 해제
                    board[row][col] = ".";
                }
            }
        }

        public boolean canReplace(int row, int col, String[][] board, int n){

            // 같은 열에 퀸이 존재하는지 확인
            for (int i = 0; i < row; i++){
                if (board[i][col].equals("Q")){
                    return false;
                }
            }

            // 왼쪽 대각선에 퀸이 존재하는지 확인
            for (int i = row-1, j = col-1; i >= 0 && j>= 0 ; i--, j--){
                if(board[i][j].equals("Q")){
                    return false;
                }
            }

            // 오른쪽 대각선 확인
            for (int i = row -1 , j = col + 1 ; i >= 0 && j < n; i-- , j++){
                if(board[i][j].equals("Q")){
                    return false;
                }
            }

            return true;
        }

        // 반환 값 : 가능한 모든 퀸 위치
        public List<List<String>> solveNQueens(int n) {

            List<List<String>> answer = new ArrayList<>();

            // board 2차원 배열 생성
            String[][] board = new String[n][n];

            // 초기 배열은, "." 으로 모두 채우자.
            for (String[] b : board){
                Arrays.fill(b , ".");
            }


            // 0번째 행부터 퀸을 배치하는 것으로 시작한다.
            dfs(0, n, board, answer);
            return answer;
        }
    }

}
