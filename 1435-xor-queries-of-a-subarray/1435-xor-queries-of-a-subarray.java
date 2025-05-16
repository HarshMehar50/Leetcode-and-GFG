class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pxor = new int[arr.length];
        pxor[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            pxor[i] = pxor[i-1]^arr[i];
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            if(queries[i][0] != 0)
            ans[i] = pxor[queries[i][1]]^pxor[queries[i][0]-1];
            else
            ans[i] = pxor[queries[i][1]];
        }
        return ans;
    }
}