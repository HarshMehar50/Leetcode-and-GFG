class Solution {
    boolean palindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r))
            return false;
            l++;
            r--;
        }
        return true;
    }
    public int longestPalindrome(String s, String t) {
        int ans = 0;
        for(int l1 = 0; l1 <= s.length(); l1++){
            for(int i = 0; i+l1-1 < s.length(); i++){
                for(int l2 = 0; l2 <= t.length(); l2++){
                    for(int j = 0; j+l2-1 < t.length(); j++){
                        String sb = s.substring(i , i+l1)+t.substring(j , j+l2);
                        if(palindrome(sb))
                        ans = Math.max(ans , l1+l2);
                    }
                }
            }
        }
        return ans;
    }
}