class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new HashSet<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean v[] = new boolean[nums.length];
        v[0] = true;
        q.offer(0);

        int jumps = 0;
        
        while(!q.isEmpty()){
            int size = q.size();

            for(int x=0; x<size; x++){
                int i = q.poll();

                if(i == n-1) return jumps;
            
                int f = i+1;
                int b = i-1;
                                
                if(f<nums.length && !v[f]){
                    v[f] = true;
                    q.offer(f);
                }
                if(b>=0 && !v[b]){
                    v[b] = true;
                    q.offer(b);
                }
                
                if(map.containsKey(nums[i])){
                    for(int idx : map.get(nums[i])){
                        if(!v[idx]){
                            v[idx] = true;
                            q.offer(idx);
                        }
                    }

                    map.remove(nums[i]);
                }

            }
            jumps++;
        }

        return 0;
    }
}