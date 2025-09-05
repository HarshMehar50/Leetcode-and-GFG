class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long s = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
            s += nums[i];
        }
        if(map.size() == k)
            ans = Math.max(ans , s);
        for(int i = k; i < nums.length; i++){
            map.put(nums[i-k] , map.get(nums[i-k])-1);
            if(map.get(nums[i-k]) == 0)
                map.remove(nums[i-k]);
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
            s += nums[i];
            s -= nums[i-k];
            if(map.size() == k)
                ans = Math.max(ans , s);
        }
        return ans;
    }
}