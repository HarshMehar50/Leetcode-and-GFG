class Solution {
    public boolean queryString(String s, int n) {
        for(int i = 1; i <= n; i++){
            String bs = Integer.toBinaryString(i);
            if(!s.contains(bs))
            return false;
        }
        return true;
    }
}