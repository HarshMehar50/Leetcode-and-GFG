class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] d = new int[nums.length];
        for(int i = 0; i < queries.length; i++){
            d[queries[i][0]]--;
            if(queries[i][1] != nums.length-1)
            d[queries[i][1]+1]++;
        }
        for(int i = 1; i < d.length; i++){
            d[i] += d[i-1];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] += d[i];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
            return false;
        }
        return true;
    }
}