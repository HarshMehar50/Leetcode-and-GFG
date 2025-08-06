class Solution {
    int[] stm;
    int n;
    void build(int[] heights , int i , int l , int r){
        if(l == r)
        stm[i] = l;
        else{
            int m = l+(r-l)/2;
            build(heights , (2*i)+1 , l , m);
            build(heights , (2*i)+2 , m+1 , r);
            if(heights[stm[(2*i)+1]] >= heights[stm[(2*i)+2]])
            stm[i] = stm[(2*i)+1];
            else
            stm[i] = stm[(2*i)+2];
        }
    }
    int query(int[] heights , int i , int l , int r , int ql , int qr){
        if(qr < l || ql > r)
        return -1;
        if(ql <= l && r <= qr)
        return stm[i];
        int m = l+(r-l)/2;
        int left = query(heights , (2*i)+1 , l , m , ql , qr);
        int right = query(heights , (2*i)+2 , m+1 , r , ql , qr);
        if(left == -1)
        return right;
        if(right == -1)
        return left;
        if(heights[left] >= heights[right])
        return left;
        else
        return right;
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        n = heights.length;
        stm = new int[4*n];
        build(heights , 0 , 0 , n-1);
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            if(queries[i][0] == queries[i][1])
            ans[i] = queries[i][0];
            else if(heights[Math.max(queries[i][0] , queries[i][1])] > heights[Math.min(queries[i][0] , queries[i][1])])
            ans[i] = Math.max(queries[i][0] , queries[i][1]);
            else{
                int s = Math.max(queries[i][0] , queries[i][1])+1;
                int e = heights.length-1;
                ans[i] = -1;
                while(s <= e){
                    int m = s+(e-s)/2;
                    int max = query(heights , 0 , 0 , n-1 , s , m);
                    if(max != -1 && heights[max] > Math.max(heights[queries[i][0]] , heights[queries[i][1]])){
                        ans[i] = max;
                        e = m-1;
                    }else
                    s = m+1;
                }
            }
        }
        return ans;
    }
}