class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long p = 1;
        for(int i = 0; i < nums.length; i++){
            p = (long)((long)p*(long)nums[i]);
        }
        for(int mask = 1; mask < (1<<nums.length); mask++){
            long p1 = 1;
            long p2 = 1;
            for(int i = 0; i < nums.length; i++){
                if((mask&(1<<i)) != 0)
                    p1 = (long)((long)p1*(long)nums[i]);
                else
                    p2 = (long)((long)p2*(long)nums[i]);
            }
            if(p1 == target && p2 == target)
                return true;
        }
        return false;
    }
}