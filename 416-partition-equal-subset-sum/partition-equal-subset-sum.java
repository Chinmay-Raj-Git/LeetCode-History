class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums)
            sum += n;

        if(sum%2 != 0) return false;
        int target = sum / 2;

        int[][] dp = new int[nums.length+1][target+1];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return recur(0, 0, target, nums, dp);
    }

    private boolean recur(int i, int sum, int target, int[] nums, int[][] dp){
        if(sum == target) return true;
        if(i >= nums.length) return false;

        if(dp[i][sum] != -1)
            if(dp[i][sum] == 0) return false;
            else return true;

        boolean include = false;
        if(sum+nums[i] <= target) 
            include = recur(i+1, sum+nums[i], target, nums, dp);

        boolean exclude = false;    
        if(!include)
            exclude = recur(i+1, sum, target, nums, dp);

        if(include || exclude)
            dp[i][sum] = 1;
        else
            dp[i][sum] = 0;

        return include || exclude;
    }
}