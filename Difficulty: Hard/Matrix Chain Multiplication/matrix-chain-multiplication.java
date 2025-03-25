//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int solve(int[] arr , int l , int r , int[][] dp){
        if(l+1 == r)
        return 0;
        if(dp[l][r] != -1)
        return dp[l][r];
        int ans = Integer.MAX_VALUE;
        for(int i = l+1; i < r; i++){
            ans = Math.min(ans , (arr[l]*arr[i]*arr[r])+solve(arr , l , i , dp)+solve(arr , i , r , dp));
        }
        dp[l][r] = ans;
        return dp[l][r];
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int[][] dp = new int[arr.length][arr.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(arr , 0 , arr.length-1 , dp);
    }
}