class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        boolean[] present = new boolean[100001];
        for(int x : nums) present[x] = true;
        
        List<List<Integer>> ans = new ArrayList<>();
        System.out.println(nums.length);

        int start = -1;
        int end = -1;
        for(int i=lower; i<=upper; i++){
            if(!present[i]){
                if(start == -1){
                    start = i;
                }
            }
            else{
                if(start != -1){
                    end = i-1;
                    ans.add(Arrays.asList(start, end));
                    start = -1;
                }
            }
        }

        if(start != -1){
            end = upper;
            ans.add(Arrays.asList(start, end));
        }
        
        // System.out.println(ans);
        
        return ans;
    }
}