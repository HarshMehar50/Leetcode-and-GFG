class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    int subgcd(int[] nums , int l , int r){
        int g = nums[l];
        for(int i = l+1; i <= r; i++){
            g = gcd(g , nums[i]);
        }
        return g;
    }
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        for(int l = 1; l <= nums.length; l++){
            for(int i = 0; i+l-1 < nums.length; i++){
                if(l == 1 && nums[i] == k)
                ans++;
                else{
                    int g = subgcd(nums , i , i+l-1);
                    if(g == k)
                    ans++;
                }
            }
        }
        return ans;
    }
}