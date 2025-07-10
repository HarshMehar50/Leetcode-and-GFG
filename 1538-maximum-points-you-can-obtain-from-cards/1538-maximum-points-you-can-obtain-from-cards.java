class Solution {
    /*int solve(int[] cardPoints , int k , int l , int r){
        if(k <= 0 || l >= r)
        return 0;
        int left = cardPoints[l]+solve(cardPoints , k-1 , l+1 , r);
        int right = cardPoints[r]+solve(cardPoints , k-1 , l , r-1);
        int ans = Math.max(left , right);
        return ans; 
    }*/
    public int maxScore(int[] cardPoints, int k) {
        //return solve(cardPoints , k , 0 , cardPoints.length-1);
        int[] a = new int[2*k];
        for(int i = 0; i < k; i++){
            a[k+i] = cardPoints[i];
        }
        for(int i = cardPoints.length-k; i < cardPoints.length; i++){
            a[i-cardPoints.length+k] = cardPoints[i];
        }
        int s = 0;
        for(int i = 0; i < k; i++){
            s += a[i];
        }
        int ans = s;
        for(int i = k; i < a.length; i++){
            s -= a[i-k];
            s += a[i];
            ans = Math.max(ans , s);
        }
        return ans;
    }
}