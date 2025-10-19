class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        for(int l = 0; l < nums.length; l++){
            Set<Integer> se = new HashSet<>();
            Set<Integer> so = new HashSet<>();
            for(int r = l; r < nums.length; r++){
                if(nums[r]%2 == 0)
                se.add(nums[r]);
                else
                so.add(nums[r]);
                if(se.size() == so.size())
                ans = Math.max(ans , r-l+1);
            }
        }
        return ans;
    }
}