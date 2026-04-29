class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();

        for(String mail: emails) 
        {
            int at = mail.indexOf('@');

            String local = mail.substring(0, at);
            String domain = mail.substring(at);
            int plus = local.indexOf('+');

            if(plus != -1)
                local = local.substring(0,plus);
            local = local.replace(".", "");

            set.add(local + domain);
        }

        return set.size();

    }
}