//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int solve(String x , String y , int i , int j , int[][] dp){
        if(i == x.length()){
            return 0;
        }
        if(j == y.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int move1 = 0;
        int move2 = 0;
        int ans = 0;
        if(x.charAt(i) == y.charAt(j)){
        return 1+solve(x , y , i+1 , j+1 , dp);
        }else{
            move1 = solve(x , y , i+1 , j , dp);
            move2 = solve(x , y , i , j+1 , dp);
            ans = Math.max(move1 , move2);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int[][] dp = new int[X.length()+1][Y.length()+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        int lcs = solve(X , Y , 0 , 0 , dp);
        return X.length()+Y.length()-lcs;
    }
}