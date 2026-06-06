class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            left[i] = sum;
            sum += nums[i];
        }
        for(int i=0; i<nums.length; i++){
            sum -= nums[i];
            right[i] = sum;
        }
        
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = Math.abs(left[i] - right[i]);
        }

        return ans;
    }
}