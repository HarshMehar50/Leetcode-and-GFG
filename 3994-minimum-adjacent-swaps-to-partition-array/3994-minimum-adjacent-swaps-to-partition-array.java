class Solution {
    final int mod = 1000000007;
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        int[] a1 = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < a)
            a1[i] = 0;
            else if(nums[i] > b)
            a1[i] = 2;
            else
            a1[i] = 1;
        }
        int[] sc = new int[3];
        int ans = 0;
        for(int i = a1.length-1; i >= 0; i--){
            sc[a1[i]]++;
            for(int j = 0; j < a1[i]; j++){
                ans = (ans+sc[j])%mod;
            }
        }
        return ans;
    }
}