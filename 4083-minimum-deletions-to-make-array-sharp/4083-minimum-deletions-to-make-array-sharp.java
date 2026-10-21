class Solution {
    public int minDeletions(int[] nums) {
        int i = 0;
        int ans = 0;
        while(i < nums.length){
            int j = i+1;
            while(j < nums.length && nums[i] == nums[j]){
                j++;
            }
            int c = j-i;
            ans += c-1;
            i = j;
        }
        return ans;
    }
}