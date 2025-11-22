class Solution {
    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        String r = new StringBuilder(s).reverse().toString();
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != r.charAt(i))
            ans++;
        }
        return ans;
    }
}