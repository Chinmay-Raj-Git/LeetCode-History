class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0) return 0;
        
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        long sum = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)-'0' != 0){
                sum += s.charAt(i) - '0';
                sb.append(s.charAt(i));
            }
        }

        return sum * Long.parseLong(sb.toString());
        
    }
}