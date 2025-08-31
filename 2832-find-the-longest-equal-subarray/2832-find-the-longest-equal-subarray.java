class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer , Integer> f = new HashMap<>();
        int l = 0;
        int ans = 0;
        int max = 0;
        for(int r = 0; r < nums.size(); r++){
            f.put(nums.get(r) , f.getOrDefault(nums.get(r) , 0)+1);
            max = Math.max(max , f.get(nums.get(r)));
            while(l <= r && r-l+1-max > k){
                f.put(nums.get(l) , f.get(nums.get(l))-1);
                l++;
            }
            if(r-l+1-max <= k)
            ans = Math.max(ans , max);
        }
        return ans;
    }
}