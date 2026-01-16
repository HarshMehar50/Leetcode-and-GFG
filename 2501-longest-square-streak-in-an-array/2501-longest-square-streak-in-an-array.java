class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            int s = nums[i];
            int c = 1;
            while(s != -1){
                int j = -1;
                if((long)((long)s*(long)s) <= nums[nums.length-1])
                j = Arrays.binarySearch(nums , s*s);
                if(j < 0 || j >= nums.length)
                s = -1;
                else{
                    c++;
                    s = nums[j];
                }
            }
            if(c > 1)
            ans = Math.max(ans , c);
        }
        return ans;
    }
}