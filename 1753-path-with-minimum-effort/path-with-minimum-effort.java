class Solution {
    public int minimumEffortPath(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dir = {
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1},
        };

        int[][] dis = new int[r][c];
        for(int[] subDis : dis)
            Arrays.fill(subDis, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        q.add(new int[]{0, 0, 0});
        dis[0][0] = 0;

        while(!q.isEmpty()){
            int[] node = q.poll();

            int x = node[0];
            int y = node[1];
            int diff = node[2];

            if(x == r-1 && y == c-1) return diff;

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx >= 0 && nx < r && ny >= 0 && ny < c){
                    int newDiff = Math.abs(grid[nx][ny] - grid[x][y]);
                    int newEff = Math.max(newDiff, diff);

                    if(newEff < dis[nx][ny]){
                        q.add(new int[]{nx, ny, newEff});
                        dis[nx][ny] = newEff;
                    }
                }
            }
        }

        return 0;
    }
}

