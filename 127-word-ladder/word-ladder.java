class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> list) {
        if(!list.contains(endWord)) return 0;
        
        HashSet<String> set = new HashSet<>();
        for(String strin : list){
            set.add(strin);
        }

        HashMap<String, List<String>> map = new HashMap<>();

        // for(int i=0; i<list.size(); i++){
        //     map.put(list.get(i), getEdges(list.get(i), set));
        // }
        map.put(beginWord, getEdges(beginWord, set));

        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();

        q.add(beginWord);
        vis.add(beginWord);

        int steps = 1;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                String cur = q.poll();

                if(cur.equals(endWord))
                    return steps;

                for(String nei : map.get(cur)){

                    if(vis.contains(nei))
                        continue;
                    
                    if(!map.containsKey(nei))
                        map.put(nei, getEdges(nei, set));
                    vis.add(nei);
                    q.add(nei);
                }
            }

            steps++;
        }

        return 0;

    }

    private List<String> getEdges(String str, HashSet<String> set){
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder(str);


        for(int i=0; i<str.length(); i++){
            for(char c = 'a'; c<='z'; c++){
                s.setCharAt(i, c);
                if(s.toString().equals(str)) continue;
                if(set.contains(s.toString())) res.add(s.toString());
                s.setCharAt(i, str.charAt(i));                 
            }
        }

        return res;
    }
}