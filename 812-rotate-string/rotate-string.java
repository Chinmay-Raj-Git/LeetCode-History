class Solution {
    public boolean rotateString(String s, String goal) {
        int shifts = 0;
        if(s.equals(goal)) return true;
        while(shifts < s.length()-1){
            String str = s.substring(shifts+1) + s.substring(0, shifts+1);
            // System.out.println(str);
            if(str.equals(goal))
                return true;
            shifts++;
        }
        return false;
    }
}