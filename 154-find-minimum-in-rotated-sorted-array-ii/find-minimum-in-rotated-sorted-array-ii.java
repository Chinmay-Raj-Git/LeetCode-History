class Solution {
    public int findMin(int[] nums) {

        for(int i=0, j=1; i<nums.length-1; i++, j++){
            if(nums[i] > nums[j]){
                return nums[j];
            }
        }

        return nums[0];
    }
}