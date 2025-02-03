class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int s = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length-1; i++){
            s += Math.abs(nums[i]-nums[i+1]);
            max = Math.max(max , Math.min(nums[i] , nums[i+1]));
            min = Math.min(min , Math.max(nums[i] , nums[i+1]));
        }
        /*int ans = 0;
        for(int i = 1; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                int a = Math.abs(nums[j]-nums[i-1])+Math.abs(nums[j+1]-nums[i])-Math.abs(nums[j+1]-nums[j])-Math.abs(nums[i-1]-nums[i]);
                ans = Math.max(ans , s+a);
            }
        }
        return ans;*/
        int a = 0;
        for(int i = 0; i < nums.length-1; i++){
            a = Math.max(a , Math.abs(nums[0]-nums[i+1])-Math.abs(nums[i]-nums[i+1]));
        }
        for(int i = 0; i < nums.length-1; i++){
            a = Math.max(a , Math.abs(nums[nums.length-1]-nums[i])-Math.abs(nums[i]-nums[i+1]));
        }
        a = Math.max(a , 2*(max-min));
        int ans = a+s;
        return ans;
    }
}