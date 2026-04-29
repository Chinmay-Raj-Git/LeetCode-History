class Solution {
    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        HashMap<String, Integer> map = new HashMap<>();
        int idx = 0;

        for(String name : names){
            if(map.containsKey(name)){
                Integer val = map.get(name);
                StringBuilder s = new StringBuilder(name);
                s.append("(");
                s.append(val);
                s.append(")");
                while(map.containsKey(s.toString())){
                    val++;
                    s = new StringBuilder(name);
                    s.append("(");
                    s.append(val);
                    s.append(")");
                }
                res[idx++] = s.toString();
                map.put(s.toString(), 1);
                map.put(name, val+1);
            }
            else{
                res[idx++] = name;
                map.put(name, 1);
            }

            // for(int x=0; x<names.length; x++){
            //     if(res[x] == null)
            //         break;
            //     System.out.print(res[x] + ", ");
            // }
            // System.out.println();
            // for(Map.Entry<String, Integer> e : map.entrySet()){
            //     System.out.print(e.getKey()+"-"+e.getValue() + "--- ");
            // }
            // System.out.println();
            // System.out.println();
        }

        return res;
    }
}