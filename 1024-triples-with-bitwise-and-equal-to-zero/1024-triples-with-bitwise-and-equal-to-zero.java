class Solution {
    public int countTriplets(int[] nums) {
        int[] maskc = new int[(int)(1<<16)];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                maskc[nums[i]&nums[j]]++;
            }
        } 
        int ans = 0;
        for(int i = 0; i < maskc.length; i++){
            for(int j = 0; j < nums.length; j++){
                if((i&nums[j]) == 0)
                ans += maskc[i];
            }
        }
        return ans;
    }
}