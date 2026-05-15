class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            if(!set.contains(n)){
                min = Math.min(min, n);
                set.add(n);
            }
        }

        return min;
    }
}