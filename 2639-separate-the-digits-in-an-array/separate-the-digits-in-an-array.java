class Solution {
    public int[] separateDigits(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(n > 9){
                String s = String.valueOf(n);
                for(char c : s.toCharArray()){
                    m.put(idx++, c - '0');
                    // System.out.print(c + " ");
                }
            }
            else
                m.put(idx++, n);
        }

        int[] res = new int[m.size()];
        idx = 0;
        while(idx < m.size()){
            res[idx] = m.get(idx++);
        }
        

        return res;
    }
}