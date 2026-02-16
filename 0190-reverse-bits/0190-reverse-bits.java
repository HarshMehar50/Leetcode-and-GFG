class Solution {
    public int reverseBits(int n) {
        /*StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        sb.reverse();
        int ans = 0;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '1')
            ans += (1<<(sb.length()-1-i));
        }
        return ans;*/
        int ans = 0;
        for(int i = 0; i < 32; i++){
            ans <<= 1;          
            ans |= (n & 1);     
            n >>= 1;            
        }
        return ans;
    }
}