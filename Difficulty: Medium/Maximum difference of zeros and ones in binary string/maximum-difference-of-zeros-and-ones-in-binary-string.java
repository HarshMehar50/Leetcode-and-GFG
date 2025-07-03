// User function Template for Java

class Solution {
    int maxSubstring(String S) {
        // code here
        int s = 0;
        int maxs = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '0')
            s += 1;
            else
            s -= 1;
            if(s < 0)
            s = 0;
            maxs = Math.max(maxs , s);
        }
        if(maxs == 0)
        return -1;
        return maxs;
    }
}