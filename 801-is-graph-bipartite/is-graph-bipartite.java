class Solution {
    public boolean isBipartite(int[][] graph) {

        HashMap<Integer, Integer> level = new HashMap<>();

        for(int start = 0; start < graph.length; start++) {

            if(level.containsKey(start))
                continue;

            Queue<Integer> q = new LinkedList<>();

            q.offer(start);
            level.put(start, 0);

            while(!q.isEmpty()) {

                int node = q.poll();

                for(int nei : graph[node]) {

                    if(!level.containsKey(nei)) {

                        level.put(nei, level.get(node) + 1);
                        q.offer(nei);

                    } else {

                        if((level.get(nei) % 2) ==
                           (level.get(node) % 2))
                            return false;
                    }
                }
            }
        }

        return true;
    }
}