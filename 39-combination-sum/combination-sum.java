class Solution {
    public List<List<Integer>> combinationSum(int[] c, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(c.length==0 || target==0)return res;
        explore(res, 0, c, new ArrayList<>(),
               target, 0);
        return res;
    }

    private void explore(
        List<List<Integer>> res, int total,
        int[] c, List<Integer> comb, int target,
        int idx
    ){
        if(idx == c.length){
            if(target==0) res.add(new ArrayList<>(comb));
            return;
        }

        if(total == target){
            res.add(new ArrayList<>(comb));
            return;
        }

        if(total > target || idx >= c.length)
            return;

        comb.add(c[idx]);
        explore(res, total+c[idx], c, comb,
               target, idx);
        comb.remove(comb.size()-1);
        explore(res, total, c, comb,
               target, idx+1);
            
    }
}