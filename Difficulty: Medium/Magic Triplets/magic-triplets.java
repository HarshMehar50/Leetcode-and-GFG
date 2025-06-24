// User function Template for Java

class Solution {
    public int countTriplets(int[] nums) {
        // code here
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int l = 0;
            int r = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                l++;
            }
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > nums[i])
                r++;
            }
            ans += (l*r);
        }
        return ans;
    }
}