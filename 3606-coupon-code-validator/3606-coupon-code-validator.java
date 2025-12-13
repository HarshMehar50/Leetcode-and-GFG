class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
        TreeMap<String , List<String>> map = new TreeMap<>();
        for(int i = 0; i < businessLine.length; i++){
            map.put(businessLine[i] , new ArrayList<>());
        }
        String[][] a = new String[code.length][3];
        for(int i = 0; i < code.length; i++){
            a[i][0] = code[i];
            a[i][1] = businessLine[i];
            if(isActive[i])
                a[i][2] = "1";
            else
                a[i][2] = "0";
        }
        Arrays.sort(a , Comparator.comparing(x->x[1]));
        for(int i = 0; i < a.length; i++){
            if(a[i][2].equals("1")){
                if(a[i][1].equals("electronics") || a[i][1].equals("pharmacy") || a[i][1].equals("grocery") || a[i][1].equals("restaurant")){
                    int c = 0;
                    if(a[i][0].length() != 0){
                    for(int j = 0; j < a[i][0].length(); j++){
                        if((a[i][0].charAt(j) >= 'a' && a[i][0].charAt(j) <= 'z') || (a[i][0].charAt(j) >= 'A' && a[i][0].charAt(j) <= 'Z') || (a[i][0].charAt(j) >= '0' && a[i][0].charAt(j) <= '9') || a[i][0].charAt(j) == '_')
                            c++;
                    }
                    if(c == a[i][0].length())
                        map.get(a[i][1]).add(a[i][0]);
                    }
                }
            }
        }
        for(String s : map.keySet()){
            Collections.sort(map.get(s));
        }
        //Collections.sort(map);
        //Collections.sort(ans);
        /*for(int i = 0; i < ans.size(); i++){
            if(ans.get(i).equals(""))
                ans.remove("");
        }*/
        for(String s : map.keySet()){
            ans.addAll(map.get(s));
        }
        for(int i = 0; i < ans.size(); i++){
            if(ans.get(i).equals(""))
                ans.remove("");
        }
        return ans;
    }
}