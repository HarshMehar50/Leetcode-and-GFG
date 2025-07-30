class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        // BRUTE
        /*TreeMap<Integer , Integer> f = new TreeMap<>();
        int l = 0;
        int ans = 0;
        for(int r = 0; r < nums.length; r++){
            f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
            while(l <= r && !(f.size() == 1 && f.firstKey() == max)){
                f.put(nums[l] , f.get(nums[l])-1);
                if(f.get(nums[l]) == 0)
                f.remove(nums[l]);
                l++;
            }
            if(f.size() == 1 && f.firstKey() == max)
            ans = Math.max(ans , r-l+1);
        } 
        return ans;*/

        // OPTIMAL
        int ans = 1;
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max)
            c++;
            else{
                ans = Math.max(ans , c);
                c = 0;
            }
        }
        ans = Math.max(ans , c);
        return ans;
    }
}