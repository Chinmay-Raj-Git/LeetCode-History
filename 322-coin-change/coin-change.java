class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<=coins.length; i++)
            Arrays.fill(dp[i], -1);

        int ans = findMin(0, amount, coins, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    private int findMin(int i, int target, int[] coins, int[][] dp){
        if(target == 0) return 0;
        if(i>=coins.length) return Integer.MAX_VALUE;

        if(dp[i][target] != -1) return dp[i][target];

        int include = Integer.MAX_VALUE;
        if(coins[i] <= target){
            include = findMin(i, target-coins[i], coins, dp);
            if(include != Integer.MAX_VALUE) include++;
        }
        int exclude = findMin(i+1, target, coins, dp);

        dp[i][target] = Math.min(include, exclude);
        return dp[i][target];
    }
}