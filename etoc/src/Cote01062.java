public class Cote01062 {

    static class Solution {

        public boolean answer = false;
        public int[] dx = {1,-1,0,0};
        public int[] dy = {0,0,-1,1};

        public boolean dfs(int x, int y, int idx, boolean[][] visited, String word, char[][] board, int m, int n){
            // base
            if (idx == word.length()){
                return true;
            }

            // 4방향 격자 탐색
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                    if (board[nx][ny] == word.charAt(idx)){
                        visited[nx][ny] = true;
                        if (dfs(nx, ny, idx + 1, visited, word, board, m, n)){
                            return true;
                        }
                        visited[nx][ny] = false; // 새로운 경로로 탐색을 이어나가야 하므로 방문 해제
                    }
                }
            }

            return false;

        }
        public boolean exist(char[][] board, String word) {

            // board 배열 안에 word 가 있으면 true 를 반환 , 없으면 false 를 반환

            int m = board.length; // 행 길이
            int n = board[0].length;  // 열 길이

            boolean visited[][] = new boolean[m][n];
            char start = word.charAt(0);

            for (int i = 0; i < m; i ++){
                for (int j = 0; j < n; j++){
                    if (board[i][j] == start){ // word 의 첫번째 글자와 같은 위치에서 dfs 시작

                        visited[i][j] = true;
                        if (dfs(i, j , 1, visited, word, board, m, n)){
                            return true;
                        }

                        visited[i][j] = false;
                    }
                }
            }

            return answer;
        }
    }
}
