class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] por = new int[arr.length];
        por[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            por[i] = por[i-1]^arr[i];
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            if(queries[i][0] != 0)
            ans[i] = por[queries[i][1]]^por[queries[i][0]-1];
            else
            ans[i] = por[queries[i][1]];
        }
        return ans;
    }
}