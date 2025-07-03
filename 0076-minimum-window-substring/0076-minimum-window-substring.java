class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
        return "";
        HashMap<Character , Integer> map = new HashMap<>();
        int c = t.length();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i) , map.getOrDefault(t.charAt(i) , 0)+1);
        }
        int l = 0;
        int s1 = -1;
        int ansl = Integer.MAX_VALUE;
        for(int r = 0; r < s.length(); r++){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) > 0)
            c--;
            map.put(s.charAt(r) , map.getOrDefault(s.charAt(r) , 0)-1);
            while(c == 0){
                if(r-l+1 < ansl){
                    ansl = r-l+1;
                    s1 = l;
                }
                map.put(s.charAt(l) , map.getOrDefault(s.charAt(l) , 0)+1);
                if(map.containsKey(s.charAt(l)) && map.get(s.charAt(l)) > 0)
                c++;
                l++;
            }
        }
        if(s1 == -1)
        return "";
        return s.substring(s1 , s1+ansl);
    }
}