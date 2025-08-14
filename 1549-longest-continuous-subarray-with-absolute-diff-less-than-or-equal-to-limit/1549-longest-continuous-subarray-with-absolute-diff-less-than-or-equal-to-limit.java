class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0;
        int ans = 0;
        TreeMap<Integer , Integer> f = new TreeMap<>();
        for(int r = 0; r < nums.length; r++){
            f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
            while(l <= r && f.lastKey()-f.firstKey() > limit){
                f.put(nums[l] , f.get(nums[l])-1);
                if(f.get(nums[l]) == 0)
                f.remove(nums[l]);
                l++;
            }
            if(f.lastKey()-f.firstKey() <= limit)
            ans = Math.max(ans , r-l+1);
        }
        return ans;
    }
}