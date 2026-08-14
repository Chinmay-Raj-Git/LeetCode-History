class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs[0].length() == 0)
            return "";
        String prefix = strs[0].substring(0, 1);
        int len = 1;

        for(int i=0; ; i++){
            int flag = 0;

            for(String s : strs){
                if(!(s.regionMatches(0, prefix, 0, len)))
                    flag = 1;
            }
            if(flag == 0){
                len++;
                if(len <= strs[0].length())
                    prefix = strs[0].substring(0, len);
                else
                    return prefix;
            }
            else{
                return prefix.substring(0, prefix.length()-1);
            }
        }

        // return "";
    }
}