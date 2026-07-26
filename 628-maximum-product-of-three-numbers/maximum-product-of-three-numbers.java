class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        // int[] a = new int[n];
        // for(int i=0; i<n; i++)  a[i] = Math.abs(nums[i]);

        Arrays.sort(nums);
        // Arrays.sort(a);

        int p1 = nums[n-1] * nums[n-2] * nums[n-3];
        int p2 = nums[0] * nums[1] * nums[n-1];
        // int p2 = a[n-1] * a[n-2] * a[n-3];


        return Math.max(p1, p2) ;
    }
}