class Solution {
    public int[] sumZero(int n) {
        if(n == 2)
        return new int[]{1 , -1};
        int[] ans = new int[n];
        int s = 0;
        for(int i = 0; i < n-1; i++){
            ans[i] = i;
            s += i;
        }
        ans[n-1] = -s;
        return ans;
    }
}