class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        /*HashMap<Integer , Integer> f = new HashMap<>();
        int l = 0;
        int max = 0;
        int ans = 0;
        for(int r = 0; r < nums.length; r++){
            f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
            max = Math.max(max , f.get(nums[r]));
            while(l <= r && max > k){
                int v = f.get(nums[l]);
                f.put(nums[l] , f.get(nums[l])-1);
                if(f.get(nums[l]) == 0)
                f.remove(nums[l]);
                if(v == max){
                    max--;
                    for(Integer x : f.keySet()){
                        max = Math.max(max , f.get(x));
                    }
                }
                l++;
            }
            if(max <= k)
            ans = Math.max(ans , r-l+1);
        }
        return ans;*/
        HashMap<Integer , Integer> f = new HashMap<>();
        int l = 0;
        int ans = 0;
        for(int r = 0; r < nums.length; r++){
            f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
            while(l <= r && f.get(nums[r]) > k){
                f.put(nums[l] , f.get(nums[l])-1);
                l++;
            }
            if(f.get(nums[r]) <= k)
            ans = Math.max(ans , r-l+1);
        }
        return ans;
    }
}