class Solution {
    public long removeZeros(long n) {
        String s = Long.toString(n);
        long ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '0')
            ans = ans*10 + (int)(s.charAt(i)-'0');
        }
        return ans;
    }
}