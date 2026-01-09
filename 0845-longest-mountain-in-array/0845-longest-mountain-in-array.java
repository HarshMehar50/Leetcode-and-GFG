class Solution {
    public int longestMountain(int[] arr) {
        int[] dp1 = new int[arr.length];
        Arrays.fill(dp1 , 1);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1])
            dp1[i] += dp1[i-1];
        }
        int[] dp2 = new int[arr.length];
        Arrays.fill(dp2 , 1);
        for(int i = arr.length-2; i >= 0; i--){
            if(arr[i] > arr[i+1])
            dp2[i] += dp2[i+1];
        }
        int ans = 0;
        for(int i = 1; i < arr.length-1; i++){
            if(dp1[i] > 1 && dp1[i+1] == 1 && dp2[i] != 1)
            ans = Math.max(ans , dp1[i]+dp2[i+1]);
        }
        return ans;
    }
}