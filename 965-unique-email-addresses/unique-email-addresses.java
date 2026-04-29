class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();

        for(String email : emails){
            int plusFlag = 0;
            int atFlag = 0;
            StringBuilder s = new StringBuilder();

            for(char c : email.toCharArray()){

                if(atFlag == 1){
                    s.append(c);
                }
                else if(c == '+')
                    plusFlag = 1;
                else if(c == '@'){
                    atFlag = 1;
                    s.append(c);
                }
                else if(c == '.')
                    continue;
                else if(plusFlag == 0 && atFlag == 0)
                    s.append(c);
            }
            System.out.println(s.toString());
            res.add(s.toString());
        }

        return res.size();

    }
}