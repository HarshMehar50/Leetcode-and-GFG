// User function Template for Java

class Solution {
    int removals(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[j]-arr[i] >= 0 && arr[j]-arr[i] <= k){
                    int l = Math.abs(j-i)+1;
                    ans = Math.min(ans , n-l);
                }
            }
        }
        return ans;
    }
}