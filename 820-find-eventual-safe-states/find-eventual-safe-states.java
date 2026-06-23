class Solution {
    boolean v[];
    boolean pv[];
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<graph.length; i++){
            res.add(i);
        }

        v = new boolean[graph.length];
        pv = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!dfs(i, graph)) res.remove(Integer.valueOf(i));
        }

        return res;
    }

    private boolean dfs(int node, int[][] graph){
        v[node] = true;
        pv[node] = true;

        for(int adj : graph[node]){
            if(!v[adj]){
                if(!dfs(adj, graph)) return false;
            }
            else if(pv[adj]) return false;
        }

        pv[node] = false;
        return true;
    }
}