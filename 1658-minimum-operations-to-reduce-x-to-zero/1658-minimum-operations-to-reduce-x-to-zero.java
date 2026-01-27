class Solution {
    public int minOperations(int[] nums, int x) {
        int ans = -1;
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < ps.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        int t = ps[ps.length-1]-x;
        if(t == 0)
        return nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , -1);
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(ps[i]-t))
            ans = Math.max(ans , i-map.get(ps[i]-t));
            map.putIfAbsent(ps[i] , i);
        }
        if(ans == -1)
        return -1;
        return nums.length-ans;
    }
}