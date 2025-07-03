class Solution {
    public int maxScore(int[] cardPoints, int k) {
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