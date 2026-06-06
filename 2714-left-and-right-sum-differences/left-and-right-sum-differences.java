class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum = 0;
        int lsum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            sum -= val;
            nums[i] = Math.abs(lsum - sum);
            lsum += val;
        }

        return nums;
    }
}