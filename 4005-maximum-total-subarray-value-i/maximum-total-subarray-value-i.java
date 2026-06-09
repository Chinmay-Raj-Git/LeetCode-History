class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for(int n : nums){
            min = Math.min(n, min);
            max = Math.max(n, max);
        }

        return (long) (max - min)*k;
    }
}