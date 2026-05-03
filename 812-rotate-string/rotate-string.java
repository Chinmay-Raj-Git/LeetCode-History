class Solution {
    public boolean rotateString(String s, String goal) {
        int shifts = 0;
        int n = s.length();

        if(n!=goal.length()) return false;

        while (shifts <= s.length()) {
            int flag = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt((i + shifts) % n) != goal.charAt(i)) {
                    shifts++;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                return true;
        }
        return false;
    }
}