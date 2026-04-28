class Solution {
    public int minimumOperations(int[] nums) {
        int[] a = new int[nums.length];
        int stopFlag = 1;

        for(int idx=0; idx<nums.length; idx++){
            a[idx] = nums[idx];
            if(stopFlag == 1 && a[idx] != 0) stopFlag = 0;
        }

        if(stopFlag == 1) return 0;

        Arrays.sort(a);
        int x = 0;

        for(int c=1; ; c++){
            while(a[x] == 0) x++;
            for(int i=0; i<nums.length; i++){
                if(nums[i] > 0)
                    nums[i] -= a[x];
                System.out.println(nums[i] + ", ");
            }

            stopFlag = 1;
            for(int i=0; i<nums.length; i++){
                a[i] = nums[i];
                if(stopFlag == 1 && a[i] != 0) stopFlag = 0;
            }

            if(stopFlag == 1) return c;
            Arrays.sort(a);
        }

    }
}