class Solution {
    public int[] resultArray(int[] nums) {
        int[] a = new int[nums.length];
        int p0 = nums[0];
        int p1 = nums[1];
        a[1] = 1;
        for(int i = 2; i < a.length; i++){
            if(p0 > p1){
                a[i] = 0;
                p0 = nums[i];
            }else{
                a[i] = 1;
                p1 = nums[i];
            }
        }
        int[] ans = new int[a.length];
        int j = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == 0){
                ans[j] = nums[i];
                j++;
            } 
        }
        for(int i = 0; i < a.length; i++){
            if(a[i] == 1){
                ans[j] = nums[i];
                j++;
            }
        }
        return ans;
    }
}