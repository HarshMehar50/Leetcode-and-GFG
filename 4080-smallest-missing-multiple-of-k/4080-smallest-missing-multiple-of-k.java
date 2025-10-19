class Solution {
    public int missingMultiple(int[] nums, int k) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        boolean[] present = new boolean[max+1];
        for(int i = 0; i < nums.length; i++){
            present[nums[i]] = true;
        }
        for(int i = 1; i*k <= max; i++){
            if(!present[i*k])
                return i*k;
        }
        return ((max/k)+1)*k;
    }
}