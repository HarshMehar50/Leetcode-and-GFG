class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        Arrays.fill(ans , Integer.MAX_VALUE);
        for(int i = 0; i < ans.length; i++){
            if(nums.get(i)%2 == 0)
            ans[i] = -1;
            else{
                for(int j = 0; j < 32; j++){
                    int n = (nums.get(i)^(1<<j));
                    if((n|(n+1)) == nums.get(i))
                    ans[i] = Math.min(ans[i] , n);
                }
            }
        }
        return ans;
    }
}