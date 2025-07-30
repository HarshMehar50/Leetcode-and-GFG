class Solution {
    boolean check(int[] a){
        for(int i = 0; i < 31; i++){
            if(a[i] > 1)
            return false;
        }
        return true;
    }
    public int longestNiceSubarray(int[] nums) {
        int[] a = new int[31];
        int l = 0;
        int ans = 0;
        for(int r = 0; r < nums.length; r++){
            for(int i = 0; i < 31; i++){
                if((nums[r]&(1<<i)) != 0)
                a[i]++;
            }
            while(l <= r && !check(a)){
                for(int i = 0; i < 31; i++){
                    if((nums[l]&(1<<i)) != 0)
                    a[i]--;
                }
                l++;
            }
            if(check(a))
            ans = Math.max(ans , r-l+1);
        }
        return ans;
    }
}