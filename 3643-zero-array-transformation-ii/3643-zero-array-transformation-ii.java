class Solution {
    boolean predicate(int[] nums , int[][] queries , int m){
        int[] d = new int[nums.length];
        for(int i = 0; i < m; i++){
            d[queries[i][0]] += queries[i][2];
            if(queries[i][1] != nums.length-1)
            d[queries[i][1]+1] -= queries[i][2];
        }
        for(int i = 1; i < nums.length; i++){
            d[i] += d[i-1];
        }
        for(int i = 0; i < nums.length; i++){
            if(d[i] < nums[i])
            return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int s = 0;
        int e = queries.length;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(nums , queries , m)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}