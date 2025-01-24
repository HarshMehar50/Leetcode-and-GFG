class Solution {
    public int totalHammingDistance(int[] nums) {
        // BRUTE FORCE
        /*int ans = 0;
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                int x = nums[i]^nums[j];
                ans += Integer.bitCount(x);
            }
        }
        return ans;*/
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int c1 = 0;
            for(int j = 0; j < nums.length; j++){
                c1 += ((nums[j]>>i)&1);
            }
            int c0 = nums.length-c1;
            ans += (c1*c0);
        }
        return ans;
    }
}