class Solution {
    public int[] findOrder(int n, int[][] graph) {
        List<List<Integer>> g = new ArrayList<>();
        int[] res = new int[n];
        int[] ind = new int[n];

        for (int i=0; i<n; i++) {
            g.add(new ArrayList<>());
        }

        for(int i=0; i<graph.length; i++){
            g.get(graph[i][1]).add(graph[i][0]);
            ind[graph[i][0]]++;
        }


        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(ind[i] == 0) q.add(i);
        }
        int idx = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            res[idx++] = node;

            for(int adj : g.get(node)){
                ind[adj]--;
                if(ind[adj] == 0) q.add(adj);
            }
        }


        if(idx == n) return res;
        int[] ans = {};
        return ans;

    }
}