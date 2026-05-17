class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        return findMin(0, nums.length-1, nums, dp);
    }

    public int findMin(int i, int target, int[] nums, int[] dp){
        if(i == target) return 0;
        if(i > target) return Integer.MAX_VALUE;

        if(dp[i] != Integer.MAX_VALUE) return dp[i];

        int min = Integer.MAX_VALUE;

        for(int j = nums[i]; j>0; j--){
            int newMin = findMin(i+j, target, nums, dp);
            if(newMin != Integer.MAX_VALUE) newMin++;
            min = Math.min(min, newMin);
            dp[i] = min;
        }

        return dp[i];
    }
}