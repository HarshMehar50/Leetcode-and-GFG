class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        /*int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int ans = 0;
        for(int i = 1; i < nums.length; i++){
            ans += map.getOrDefault(((ps[i]%k)+k)%k , 0);
            map.put(((ps[i]%k)+k)%k , map.getOrDefault(((ps[i]%k)+k)%k , 0)+1);
        }
        return ans;*/
        int ps = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ps += nums[i];
            ans += map.getOrDefault(((ps%k)+k)%k , 0);
            map.put(((ps%k)+k)%k , map.getOrDefault(((ps%k)+k)%k , 0)+1);
        }
        return ans;
    }
}