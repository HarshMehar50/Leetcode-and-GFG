class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                int x = nums[i]^nums[j];
                ans += Integer.bitCount(x);
            }
        }
        return ans;
    }
}