class Solution {
    boolean[] v;
    boolean[] pathV;

    public boolean canFinish(int n, int[][] graph) {
        List<List<Integer>> g = new ArrayList<>();

        for (int i=0; i<n; i++) {
            g.add(new ArrayList<>());
        }

        for(int i=0; i<graph.length; i++){
            g.get(graph[i][1]).add(graph[i][0]);
        }

        v = new boolean[n];
        pathV = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!v[i])
                if(!dfs(i, g)) return false;
        }

        return true;

    }

    private boolean dfs(int node, List<List<Integer>> g){
        v[node] = true;
        pathV[node] = true;

        for(int nextNode : g.get(node)){
            if(!v[nextNode]){
                if(!dfs(nextNode, g)) return false;
            }
            else if(pathV[nextNode]) return false;
        }

        pathV[node] = false;
        return true;
        
    }
}