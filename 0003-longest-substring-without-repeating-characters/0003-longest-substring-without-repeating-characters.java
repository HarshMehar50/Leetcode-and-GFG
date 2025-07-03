class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            map.put(s.charAt(r) , map.getOrDefault(s.charAt(r) , 0)+1);
            while(l <= r && map.size() != r-l+1){
                map.put(s.charAt(l) , map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l)) == 0)
                map.remove(s.charAt(l));
                l++;
            }
            if(map.size() == r-l+1)
            ans = Math.max(ans , r-l+1);
        }
        return ans;
    }
}