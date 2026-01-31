class Solution {
    boolean predicate(int[] nums , int k){
        int op = 0;
        for(int i = 0; i < nums.length; i++){
            op += nums[i]/k;
            if(nums[i]%k != 0)
                op++;
        }
        return op <= (long)((long)k*(long)k);
    }
    public int minimumK(int[] nums) {
        int s = 1;
        int e = 0;
        for(int i = 0; i < nums.length; i++){
            e = Math.max(e , nums[i]);
        }
        e = (int)(1e9);
        int k = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(nums , m)){
                k = m;
                e = m-1;
            }else
                s = m+1;
        }
        if(k == -1)
        return nums.length;
        return k;
    }
}