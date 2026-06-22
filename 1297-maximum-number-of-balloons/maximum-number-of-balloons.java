class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] f = new int[26];
        int res = Integer.MAX_VALUE;

        String s = "balloon";

        for(char c : text.toCharArray()){
            f[c - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(s.indexOf((char)(i+'a'))>=0){
                if((char)(i+'a') == 'l' || (char)(i+'a') == 'o')
                    res = Math.min(res, f[i]/2);
                else
                    res = Math.min(res, f[i]);
            }
        }

        return res;
    }
}