class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        int g1 = gcd(numsDivide[0] , numsDivide[0]);
        int g = 0;
        for(int i = 1; i < numsDivide.length; i++){
            g = gcd(g1 , numsDivide[i]);
            g1 = g;
        }
        if(g == 0)
        g = g1;
        Arrays.sort(nums);
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            if(g%nums[i] == 0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}