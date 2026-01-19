package cote2026jan;

public class Cote0119 {

    static class Solution {

        public int[] dr = {1,-1,0,0};
        public int[] dc = {0,0,-1,1};

        public void dfs(int r, int c , char[][] grid , boolean[][] visited){

            int m = visited.length;
            int n = visited[0].length;


            for (int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n){
                    if (!visited[nr][nc] && grid[nr][nc] == '1'){
                        visited[nr][nc] = true;
                        dfs(nr, nc, grid, visited);
                    }
                }
            }
        }
        public int numIslands(char[][] grid) {

            int count = 0;
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];


            // 1은 섬, 0 은 물
            // 섬의 개수를 구하자.
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] == '1'){
                        if (!visited[i][j]){
                            visited[i][j] = true;
                            dfs(i, j , grid, visited);
                            count++;
                        }
                    }
                }
            }

            return count;

        }
    }
}
