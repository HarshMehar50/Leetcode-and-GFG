class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int ps = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i)%modulo == k)
            ps++;
            int r = ps%modulo;
            ans += map.getOrDefault((r-k+modulo)%modulo , 0);
            map.put(r , map.getOrDefault(r , 0)+1);
        }
        return ans;
    }
}