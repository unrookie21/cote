package cote2026jan;

public class Cot01102 {

    static class Solution {

        public boolean canFill(int r, int c, int i, char[][] board){
            char num = (char)(i + '0');

            // 같은 행에 중복 숫자 있는지 검증
            for (int col = 0; col < 9; col++){
                if (board[r][col] == num){
                    return false;
                }
            }

            // 같은 열에 중복 숫자 있는지 검증
            for (int row = 0; row < 9; row++){
                if (board[row][c] == num){
                    return false;
                }
            }

            // 3x3 sub box 검증
            int rowStart = (r / 3) * 3;
            int colStart = (c / 3) * 3;

            for (int row = rowStart; row < rowStart + 3; row++){
                for (int col = colStart; col < colStart + 3; col++){
                    if (board[row][col] == num){
                        return false;
                    }
                }
            }

            return true;
        }

        public boolean dfs(int n, char[][] board){
            // base
            if (n == 81){
                return true;
            }

            int r = n / 9;
            int c = n % 9;

            if (board[r][c] != '.'){
                return dfs(n + 1, board);
            } else {
                for (int i = 1; i <= 9; i++){
                    if (canFill(r, c, i, board)){
                        board[r][c] = (char)(i + '0');
                        if (dfs(n + 1, board)) return true;
                        board[r][c] = '.';
                    }
                }
            }

            return false;
        }

        public void solveSudoku(char[][] board) {
            dfs(0, board);
        }
    }
}
