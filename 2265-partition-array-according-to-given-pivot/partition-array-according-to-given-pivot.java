class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lesser = 0; int greater = 0;
        int p = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > pivot) greater++;
            else if(nums[i] < pivot) lesser++;
            else p++;
        }

        int res[] = new int[nums.length];
        int left = 0;
        int right = nums.length - greater;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < pivot)
                res[left++] = nums[i];
            else if(nums[i] > pivot)
                res[right++] = nums[i];
        }
        for(int i=1; i<=p; i++)
            res[left++] = pivot;

        return res;
    }
}