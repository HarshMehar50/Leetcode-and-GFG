class Solution {
    public long countSubarrays(int[] nums, long k) {
        TreeMap<Integer , Integer> f = new TreeMap<>();
        int l = 0;
        long ans = 0;
        for(int r = 0; r < nums.length; r++){
            f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
            while(l <= r && (long)((long)(f.lastKey()-f.firstKey())*(long)(r-l+1)) > k){
                f.put(nums[l] , f.get(nums[l])-1);
                if(f.get(nums[l]) == 0)
                f.remove(nums[l]);
                l++;
            }
            ans += r-l+1;
        }
        return ans;
    }
}