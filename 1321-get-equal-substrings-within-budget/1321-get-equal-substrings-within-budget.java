class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int sum = 0;
        int l = 0;
        int ans = 0;
        for(int r = 0; r < s.length(); r++){
            sum += Math.abs((int)(s.charAt(r)-t.charAt(r)));
            while(l <= r && sum > maxCost){
                sum -= Math.abs((int)(s.charAt(l)-t.charAt(l)));
                l++;
            }
            if(sum <= maxCost)
            ans = Math.max(ans , r-l+1);
        }
        return ans;
    }
}