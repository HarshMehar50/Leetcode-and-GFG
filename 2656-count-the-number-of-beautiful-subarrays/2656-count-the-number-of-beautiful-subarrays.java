class Solution {
    public long beautifulSubarrays(int[] nums) {
        int pxor = 0;
        HashMap<Integer , Integer> f = new HashMap<>();
        f.put(0 , 1);
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            pxor = pxor^nums[i];
            int req = pxor^0;
            ans += f.getOrDefault(req , 0);
            f.put(pxor , f.getOrDefault(pxor , 0)+1);
        }
        return ans;
    }
}