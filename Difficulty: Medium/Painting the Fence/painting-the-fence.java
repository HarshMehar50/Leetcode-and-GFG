//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    final int mod = 1000000007;
    long add(long a , long b){
        return (a%mod + b%mod)%mod;
    }
    long multiply(long a , long b){
        return ((a%mod)*(b%mod))%mod;
    }
    long solvetab(int n, int k){
        if(n == 1){
            return (long)(k%mod);
        }
        if(n == 2){
            return add((long)k , multiply((long)k , (long)(k-1)));
        }
        long[] dp = new long[n+1];
        dp[1] = k%mod;
        dp[2] = add((long)k , multiply((long)k , (long)(k-1)));
        for(int i = 3; i <= n; i++){
            dp[i] = multiply(add(dp[i-1] , dp[i-2]) , (long)(k-1));
        }
        return dp[n];
    }
    long solve(int n , int k , long[] dp){
        if(n == 1){
            return (long)(k%mod);
        }
        if(n == 2){
            return add((long)k , multiply((long)k , (long)(k-1)));
        }
        if(dp[n] != -1){
            return dp[n];
        }
        long ans = multiply(add(solve(n-1 , k , dp) , solve(n-2 , k , dp)) , (long)(k-1));
        dp[n] = ans;
        return dp[n];
    }
    long countWays(int n,int k)
    {
        //code here.
        /*long[] dp = new long[n+1];
        Arrays.fill(dp , -1);
        return solve(n , k , dp);*/
        return solvetab(n , k);
    }
}




//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);

            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.countWays(n,k);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends