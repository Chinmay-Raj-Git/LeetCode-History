class Solution {
    public int numIslands(char[][] grid) {
        int[][] dir = {
                { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
        };
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    q.offer(new int[] { i, j });
                    res++;
                }

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int[] d : dir) {
                        int nr = cur[0] + d[0];
                        int nc = cur[1] + d[1];

                        if (nr < r && nc < c && nr >= 0 && nc >= 0 && grid[nr][nc] == '1') {
                            grid[nr][nc] = '0';
                            q.offer(new int[] { nr, nc });
                        }

                    }
                }
            }

        }
        return res;
    }
}