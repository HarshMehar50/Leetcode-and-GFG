class Solution {
    boolean predicate(int[] nums , int m){
        /*int[] a = nums.clone();
        for(int i = a.length-1; i >= 0; i--){
            if(a[i] > m){
                int r = a[i]-m;
                if(i-1 >= 0)
                a[i-1] += r;
            }
        }
        for(int i = 0; i < a.length; i++){
            if(a[i] > m)
            return false;
        }
        return true;*/
        long c = 0;
        for(int i = nums.length-1; i >= 0; i--){
            long v = nums[i]+c;
            if(v > m)
            c = v-m;
            else
            c = 0;
        }
        if(c == 0)
        return true;
        else
        return false;
    }
    public int minimizeArrayValue(int[] nums) {
        int s = 0;
        int e = 0;
        for(int i = 0; i < nums.length; i++){
            e = Math.max(e , nums[i]);
        }
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(nums , m)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}