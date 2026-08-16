class Solution {
    public String lastNonEmptyString(String s) {
        int[] freq = new int[26];

        for(char c : s.toCharArray())
            freq[c-'a']++;

        int max = freq[0];
        for(int f : freq)
            max = Math.max(max, f);
        
        StringBuilder res = new StringBuilder();

        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(freq[c-'a'] == max){
                res.append(c);
                freq[c-'a'] = 0;
            }
        }

        return res.reverse().toString();
    }
}