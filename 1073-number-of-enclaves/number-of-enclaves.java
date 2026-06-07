class Solution {
    int[][] dir = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for(int i=0; i<n; i++){
            if(grid[0][i] == 1)
                dfs(grid, 0, i);
            if(grid[m-1][i] == 1)
                dfs(grid, m-1, i);
        }

        for(int i=0; i<m; i++){
            if(grid[i][0] == 1)
                dfs(grid, i, 0);
            if(grid[i][n-1] == 1)
                dfs(grid, i, n-1);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1)
                    ans++;
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 ||
           r >= grid.length ||
           c >= grid[0].length ||
           grid[r][c] != 1) return;

        grid[r][c] = -1;
        for(int[] d : dir){
            dfs(grid, r+d[0], c+d[1]);
        }
    }
}