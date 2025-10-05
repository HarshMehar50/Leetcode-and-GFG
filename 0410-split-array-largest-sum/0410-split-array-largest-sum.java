class Solution {
    boolean predicate(int[] nums , int k , int m){
        int s = 0;
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            if(s+nums[i] <= m)
            s += nums[i];
            else{
                s = nums[i];
                c++;
            }
        }
        if(c == k-1)
        return true;
        else
        return false;
    }
    public int splitArray(int[] nums, int k) {
        int s = 0;
        int e = 0;
        for(int i = 0; i < nums.length; i++){
            e += nums[i];
            s = Math.max(s , nums[i]);
        }
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(nums , k , m)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}