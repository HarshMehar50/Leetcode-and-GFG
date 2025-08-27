class Solution {
    public int[] maxValue(int[] nums) {
        int[] pmax = new int[nums.length];
        int[] smin = new int[nums.length];
        pmax[0] = nums[0];
        smin[smin.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            pmax[i] = Math.max(pmax[i-1] , nums[i]); 
        }
        for(int i = nums.length-2; i >= 0; i--){
            smin[i] = Math.min(smin[i+1] , nums[i]);
        }
        List<int[]> l = new ArrayList<>();
        int p = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(pmax[i] <= smin[i+1]){
                l.add(new int[]{p , i});
                p = i+1;
            }
        }
        l.add(new int[]{p , nums.length-1});
        int[] ans = new int[nums.length];
        for(int[] a : l){
            for(int i = a[0]; i <= a[1]; i++){
                ans[i] = pmax[a[1]];
            }
        }
        return ans;
    }
}