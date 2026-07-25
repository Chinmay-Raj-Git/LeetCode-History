class Solution {
    public int maxProduct(int n) {
        int f[] = new int[10];

        String s = String.valueOf(n);
        int nums[] = new int[s.length()];

        int i = 0;
        for(char c : s.toCharArray()){
            nums[i++] = c-'0';
        }
        int max1 = 0; int max2 = 0;
        for(int j=0; j<nums.length; j++){
            int x = nums[j];
            f[x]++;
            if(x < max1 && x > max2) max2 = x;
            else if(x > max1){
                max2 = max1;
                max1 = x;
            }
            else if(j == nums.length-1 && max1 == max2){
                max2 = x;
            }
        }

        if(f[max1] > 1) return max1 * max1;
        return max1 * max2;
    }
}