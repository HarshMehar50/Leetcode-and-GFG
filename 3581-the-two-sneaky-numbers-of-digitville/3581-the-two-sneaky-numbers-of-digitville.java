class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] f = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            f[nums[i]]++;
        }
        int i = 0;
        int[] ans = new int[2];
        for(int j = 0; j < nums.length; j++){
            if(f[j] == 2){
                ans[i] = j;
                i++;
            }
        }
        return ans;
    }
}