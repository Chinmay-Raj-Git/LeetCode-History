class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        boolean[] present = new boolean[100001];
        for(int x : nums) present[x] = true;
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        System.out.println(nums.length);

        int start = -1;
        int end = -1;
        for(int i=lower; i<=upper; i++){
            if(!present[i] && start == -1){
                start = i;
                cur.add(start);
            }
            else if(present[i] && start != -1){
                end = i-1;
                cur.add(end);
                ans.add(cur);
                cur = new ArrayList<>();
                
                start = -1;
            }
        }

        if(start != -1){
            end = upper;
            cur.add(end);
            ans.add(cur);
        }
        
        // System.out.println(ans);
        
        return ans;
    }
}