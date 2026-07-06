class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = intervals.length;
        for(int[] cur : intervals){
            for(int[] in : intervals ){
                if(Arrays.equals(in, cur)) continue;
                if(in[0] <= cur[0] && cur[1] <= in[1]){
                    res--;
                    break;
                }
            }
        }

        return res;
    }
}