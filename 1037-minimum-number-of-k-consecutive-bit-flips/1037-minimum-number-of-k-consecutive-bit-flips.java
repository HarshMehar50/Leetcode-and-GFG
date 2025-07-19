class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int ans = 0;
        int fc = 0;
        boolean[] flipped = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i >= k && flipped[i-k])
            fc++;
            if(fc%2 == nums[i]){
                if(i+k > nums.length)
                return -1;
                fc++;
                flipped[i] = true;
                ans++;
            }
        }
        return ans;
    }
}