package cote2025oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cote10251 {

    static int solveNQueens(int n){

        int[] board = new int[n];
        Arrays.fill(board , - 1);
        List<int[]> solutions = new ArrayList<>();

        DFS(0, n, board, solutions);

        return solutions.size();
    }

    static boolean canReplace(int row, int col, int[] board){

        for (int prevRow = 0; prevRow < row; prevRow++){
            // 배치하려는 행의 열에, 이미 퀸이 존재하면 false
            // 배치하려는 퀸이 대각선에 존재하는 상황이면 false
            if (board[prevRow] == col || Math.abs(prevRow - row) == Math.abs(board[prevRow] - col)){
                return false;
            }
        }
        // queen 을 배치할 수 없는 조건을 통과하면 , true 반환
        return true;
    }

    static void DFS(int row, int n, int[] board, List<int[]> solutions){

        // row == n 이 되면 탐색 종료
        if (row == n){
            solutions.add(board.clone());
        }

        // n 개만큼 col 을 가지 뻗기
        for (int col = 0; col < n; col++){
            // pruning 조건 체크. 즉, Queen 을 배치할 수 있는지 체크하고, 배치할 수 없다면 바로 return
            if(canReplace(row, col, board)){
                // Queen 을 배치할 수 있다면,
                board[row] = col; // 배치하기.
                DFS(row + 1, n, board, solutions);
                // 탐색하고 돌아왔으면, 방문해제 시켜야한다. 새로운 탐색도 진행해야하니까.
                board[row] = -1;
            }
        }
    }




    public static void main(String[] args){

       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();

       System.out.print(solveNQueens(N));


    }
}
