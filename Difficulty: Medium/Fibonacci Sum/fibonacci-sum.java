//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    static long fibSum(long N) {
        // code here
        long[] dp = new long[(int)(N+1)];
        long[] ps = new long[(int)(N+1)];
        long mod = 1000000007;
        dp[0] = 0;
        dp[1] = 1;
        ps[0] = 0;
        ps[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
            ps[i] = (ps[i-1]+dp[i])%mod;
        }
        return ps[(int)N]%mod;
    }
}

//{ Driver Code Starts.
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fibSum(N));
        }
    }
}
// } Driver Code Ends