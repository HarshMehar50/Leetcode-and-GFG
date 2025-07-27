class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character , Integer> f = new HashMap<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            f.put(s.charAt(r) , f.getOrDefault(s.charAt(r) , 0)+1);
            while(l <= r && f.size() < r-l+1){
                f.put(s.charAt(l) , f.get(s.charAt(l))-1);
                if(f.get(s.charAt(l)) == 0)
                f.remove(s.charAt(l));
                l++;
            }
            if(f.size() == r-l+1)
            ans = Math.max(ans , f.size());
        }
        return ans;
    }
}