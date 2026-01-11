class Solution {
    public int centeredSubarrays(int[] nums) {
        int ans = 0;
        /*int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }*/

        for(int l = 1; l <= nums.length; l++){
            int s = 0;
            List<Integer> l1 = new ArrayList<>();
            for(int i = 0; i < l; i++){
                s += nums[i];
                l1.add(nums[i]);
            }
            if(l1.contains(s))
            ans++;
            for(int i = l; i < nums.length; i++){
                s += nums[i]-nums[i-l];
                l1.remove(0);
                l1.add(nums[i]);
                if(l1.contains(s))
                ans++;
            }
        }
        return ans;
    }
}