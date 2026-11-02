class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += Math.abs(nums[i]-nums[nums.length/2]);
        }
        if(nums.length%2 == 0){
            int localans = 0;
            for(int i = 0; i < nums.length; i++){
                localans += Math.abs(nums[i]-nums[(nums.length/2)-1]);
            }
            ans = Math.min(ans , localans);
        }
        return ans;
    }
}