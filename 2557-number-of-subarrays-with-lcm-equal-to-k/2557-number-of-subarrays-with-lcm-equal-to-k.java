class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int l = 1;
            for(int j = i; j < nums.length; j++){
                l = (l*nums[j])/gcd(l , nums[j]);
                if(l > k)
                break;
                if(l == k)
                ans++;
            }
        }
        return ans;
    }
}