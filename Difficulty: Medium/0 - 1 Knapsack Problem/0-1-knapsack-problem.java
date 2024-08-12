//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int solve(int W, int wt[], int val[], int n , int capacity , int[][] dp) {
        if(n == 0){
            if(capacity >= wt[0])
            return val[0];
            else
            return 0;
        }
        if(dp[n][capacity] != -1){
            return dp[n][capacity];
        }
        int include = 0;
        if(wt[n] <= capacity)
        include = val[n]+solve(W , wt , val , n-1 , capacity-wt[n] , dp);
        int exclude = solve(W , wt , val , n-1 , capacity , dp);
        int ans = Math.max(include , exclude);
        dp[n][capacity] = ans;
        return dp[n][capacity];
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n][W+1];
         for(int i = 0; i < dp.length; i++){
             Arrays.fill(dp[i] , -1);
         }
         return solve(W , wt , val , n-1 , W , dp);
    } 
}


