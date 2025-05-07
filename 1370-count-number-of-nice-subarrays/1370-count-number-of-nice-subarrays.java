class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i]%2;
        }
        int ps = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0 , 1);
        for (int i = 0; i < nums.length; i++) {
            ps += nums[i];
            ans += map.getOrDefault(ps - k, 0);
            map.put(ps , map.getOrDefault(ps , 0) + 1);
        }
        return ans;
    }
}