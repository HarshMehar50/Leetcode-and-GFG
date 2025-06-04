class Solution {
public:
int solve(vector<vector<int>>&dp,vector<vector<int>>&matrix,int i,int j)
    {if(i>=dp.size() || j>=dp[0].size())return INT_MAX;
        if(i==0)return matrix[i][j];
        if(dp[i][j]!=INT_MAX)return dp[i][j];
        dp[i][j]=0;
        return dp[i][j]+=matrix[i][j]+(min(solve(dp,matrix,i-1,j-1),min(solve(dp,matrix,i-1,j),solve(dp,matrix,i-1,j+1))));

    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m=matrix.size();
        int n=matrix[0].size();
        vector<vector<int>>dp(m,vector<int>(n,INT_MAX));
        int ans=INT_MAX;
        for(int i=0;i<n;i++)
        {
            ans=min(ans,solve(dp,matrix,m-1,i));
        }
        return ans;
    }
};