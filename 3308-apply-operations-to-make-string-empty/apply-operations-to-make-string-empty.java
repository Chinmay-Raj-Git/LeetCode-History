class Solution {
    public String lastNonEmptyString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = Collections.max(map.values());
        StringBuilder res = new StringBuilder();

        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(map.get(c) == max){
                res.append(c);
                map.put(c, 0);
            }
        }

        return res.reverse().toString();
    }
}