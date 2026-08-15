class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int len = prefix.length();

        for(int i=1; i<strs.length; i++){
            // System.out.println("old p:"+prefix+" str:"+strs[i]);
            int idx = 0;
            while(prefix.length() > 0 && strs[i].length() > 0 && prefix.charAt(idx) == strs[i].charAt(idx)){
                idx++;
                if(idx >= len || idx >= strs[i].length())
                    break;
            }

            len = idx;
            if(prefix.length() != len){
                prefix = prefix.substring(0, len);
            }
            // System.out.println("new p:"+prefix+"\n\n");
        }

        return prefix;
    }
}