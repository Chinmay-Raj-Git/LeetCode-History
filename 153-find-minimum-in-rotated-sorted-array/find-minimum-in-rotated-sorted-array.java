class Solution {
    public int findMin(int[] nums) {
        int k = 0;
        int[] arr = new int[nums.length];
        for (int i = 0, j = 1; i < nums.length - 1; i++, j++)
            if (nums[i] > nums[j]) {
                k = j;
                break;
            }

        return nums[k];

    }
}