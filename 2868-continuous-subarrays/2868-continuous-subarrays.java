class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int l = 0;
        TreeMap<Integer , Integer> f = new TreeMap<>();
        for(int r = 0; r < nums.length; r++){
            f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
            while(l <= r && f.lastKey()-f.firstKey() > 2){
                f.put(nums[l] , f.get(nums[l])-1);
                if(f.get(nums[l]) == 0)
                f.remove(nums[l]);
                l++;
            }
            if(f.lastKey()-f.firstKey() <= 2)
            ans += r-l+1;
        }
        return ans;
    }
}