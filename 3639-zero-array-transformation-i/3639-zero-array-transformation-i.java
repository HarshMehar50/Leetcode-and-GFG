class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        /*int[] d = new int[nums.length];
        for(int i = 0; i < queries.length; i++){
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                d[j]++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(d[i] < nums[i])
            return false;
        }
        return true;*/
        int[] d = new int[nums.length+1];
        for(int i = 0; i < queries.length; i++){
            d[queries[i][0]]++;
            if(queries[i][1]+1 < nums.length)
            d[queries[i][1]+1]--;
        }
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            c += d[i];
            if(c < nums[i])
            return false;
        }
        return true;
    }
}