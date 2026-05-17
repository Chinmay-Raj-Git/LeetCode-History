class Solution {
    public boolean canReach(int[] nums, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        boolean v[] = new boolean[nums.length];
        v[start] = true;

        while(!q.isEmpty()){
            int i = q.poll();
            if(nums[i] == 0) return true;            

            int f = i + nums[i];
            int b = i - nums[i];

            if(f < nums.length && !v[f]){
                v[f] = true;
                q.offer(f);
            }
            if(b >= 0 && !v[b]){
                v[b] = true;
                q.offer(b);
            }
        }

        return false;

    }
}