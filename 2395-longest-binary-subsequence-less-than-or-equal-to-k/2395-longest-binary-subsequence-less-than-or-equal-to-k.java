class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0;
        int p = 0;
        int v = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '0')
            ans++;
            else{
                if(p < 32 && k-(1<<p) >= 0){
                    k = k-(1<<p);
                    ans++;
                }
            }
            p++;
        }
        return ans;
    }
}