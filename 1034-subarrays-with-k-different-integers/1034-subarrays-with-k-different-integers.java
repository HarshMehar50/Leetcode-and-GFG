class Solution {
    int solve(int[] nums , int k){
        int l = 0;
        HashMap<Integer , Integer> f = new HashMap<>();
        int ans = 0;
        for(int r = 0; r < nums.length; r++){
            f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
            int tl = l;
            while(l <= r && f.size() > k){
                f.put(nums[l] , f.get(nums[l])-1);
                if(f.get(nums[l]) == 0)
                f.remove(nums[l]);
                l++;
            }
            //if(f.size() == k)
            ans += r-l+1;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums , k)-solve(nums , k-1);
    }
}