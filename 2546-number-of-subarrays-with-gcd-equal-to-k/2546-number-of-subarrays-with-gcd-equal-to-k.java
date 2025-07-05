class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int g = 0;
            for(int j = i; j < nums.length; j++){
                g = gcd(g , nums[j]);
                if(g < k)
                break;
                if(g == k)
                ans++;
            }
        }
        return ans;
    }
}