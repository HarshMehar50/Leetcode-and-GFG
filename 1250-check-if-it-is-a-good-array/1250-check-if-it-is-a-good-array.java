class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    public boolean isGoodArray(int[] nums) {
        int g = 0;
        for(int i = 0; i < nums.length; i++){
            g = gcd(g , nums[i]);
            if(g == 1)
            return true;
        }
        return false;
    }
}