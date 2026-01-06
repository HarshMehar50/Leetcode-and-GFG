class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int mask = 0; mask < (1<<(nums.length/2)); mask++){
            int s = 0;
            for(int i = 0; i < nums.length/2; i++){
                if((mask&(1<<i)) != 0)
                s += nums[i];
            }
            ts.add(s);
        }
        int ans = Integer.MAX_VALUE;
        for(int mask = 0; mask < (1<<(nums.length-(nums.length/2))); mask++){
            int s = 0;
            for(int i = 0; i < nums.length-nums.length/2; i++){
                if((mask&(1<<i)) != 0)
                s += nums[i+(nums.length/2)];
            }
            Integer v1 = ts.ceiling(goal-s);
            if(v1 != null)
            ans = Math.min(ans , Math.abs(goal-(s+v1)));
            Integer v2 = ts.floor(goal-s);
            if(v2 != null)
            ans = Math.min(ans , Math.abs(goal-(s+v2)));
        }
        return ans;
    }
}