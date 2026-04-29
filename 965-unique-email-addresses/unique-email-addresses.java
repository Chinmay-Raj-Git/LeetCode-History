class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            int domainIndex = email.indexOf('@');
            StringBuilder sb = new StringBuilder(email.length());

            for (int index = 0; index < domainIndex; index++) {
                char ch = email.charAt(index);
                if (ch == '+')
                    break;
                if (ch != '.')
                    sb.append(ch);
            }

            sb.append(email.substring(domainIndex));
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}