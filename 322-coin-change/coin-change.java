class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<=coins.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
            
        for(int i=coins.length-1; i>=0; i--){
            for(int target = 0; target<=amount; target++){
                int include = Integer.MAX_VALUE;
                if(coins[i] <= target){
                    include = dp[i][target-coins[i]];
                    if(include != Integer.MAX_VALUE) include++;
                }
                int exclude = dp[i+1][target];
                dp[i][target] = Math.min(include, exclude);
            }
        }

        return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
    }
}