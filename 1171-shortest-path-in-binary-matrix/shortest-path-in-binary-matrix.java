class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int res = 0;
        int[][] dir = {
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1},
            {1, 1}, {1, -1},
            {-1, -1}, {-1, 1},
        };

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});

        while(!q.isEmpty()){
            int[] node = q.poll();

            int x = node[0];
            int y = node[1];
            int dist = node[2];

            if(x == n-1 && y == n-1) return dist+1;

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0){
                    q.add(new int[]{nx, ny, dist+1});
                    grid[nx][ny] = 1;
                }
            }

        }

        return -1;
        
    }
}