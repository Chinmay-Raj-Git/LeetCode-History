class Solution {
    int state[];
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();

        state = new int[graph.length];

        for(int i=0; i<graph.length; i++){
            if(dfs(i, graph)) res.add(i);
        }

        return res;
    }

    private boolean dfs(int node, int[][] graph){
        if(state[node] == 1) return false;
        if(state[node] == 3) return false;
        if(state[node] == 2) return true;

        state[node] = 1;

        for(int adj : graph[node]){
            if(!dfs(adj, graph)){
                state[node] = 3;
                return false;
            }
        }

        state[node] = 2;
        return true;
    }
}