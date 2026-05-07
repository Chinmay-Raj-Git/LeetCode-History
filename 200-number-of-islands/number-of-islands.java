class Solution {
    public int numIslands(char[][] grid) {
        int[][] dir = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;

        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    stack.push(new int[] {i, j});
                    res++;
                }

                while(!stack.isEmpty()){
                        int[] cur = stack.pop();
                        for(int[] d : dir){
                            int nr = cur[0] + d[0];
                            int nc = cur[1] + d[1];

                            if(nr<r && nc<c && nr>=0 && nc>=0 && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                stack.push(new int[] {nr, nc});
                            }

                        }
                }
            }

        }
        return res;
    }
}