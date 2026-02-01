class Solution {
    public int countMonobit(int n) {
        int ans = 0;
        for(int i = 1; Math.pow(2 , i)-1 <= n; i++){
            ans++;
        }
        return ans+1;
    }
}