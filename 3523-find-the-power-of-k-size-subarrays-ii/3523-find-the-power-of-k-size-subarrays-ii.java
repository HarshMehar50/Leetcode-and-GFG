class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] a = new int[nums.length];
        Arrays.fill(a , 1);
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] <= nums[i] && nums[i]-nums[i-1] == 1)
            a[i] += a[i-1];
        }
        int[] ans = new int[nums.length-k+1];
        Arrays.fill(ans , -1);
        for(int i = 0; i < ans.length; i++){
            if(a[i+k-1]-a[i]+1 == k)
            ans[i] = nums[i+k-1];
        }
        return ans;
    }
}