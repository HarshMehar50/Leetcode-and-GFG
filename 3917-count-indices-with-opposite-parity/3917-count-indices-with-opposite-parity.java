class Solution {
    public int[] countOppositeParity(int[] nums) {
        int[] ans = new int[nums.length];
        int se = 0;
        int so = 0;
        if(nums[nums.length-1]%2 == 0)
        se++;
        else
        so++;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i]%2 == 0)
            ans[i] = so;
            else
            ans[i] = se;
            if(nums[i]%2 == 0)
            se++;
            else
            so++;
        }
        return ans;
    }
}