class Solution {
    public int minOperations(int[] nums) {
        if(nums.length == 1)
        return 0;
        int start = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                start = i;
                break;
            }
        }
        boolean front = true;
        for(int i = 1; i < nums.length; i++){
            if(nums[(start+i)%nums.length] != i){
                front = false;
                break;
            }
        }
        boolean back = true;
        for(int i = 1; i < nums.length; i++){
            if(nums[(start-i+nums.length)%nums.length] != i){
                back = false;
                break;
            }
        }
        if(!front && !back)
        return -1;
        int ans = Integer.MAX_VALUE;
        if(front){
            if(start == 0)
            ans = 0;
            else
            ans = Math.min(ans , Math.min(start , nums.length-start+2));
        }
        if(back)
        ans = Math.min(ans , Math.min(nums.length-start , start+2));
        return ans;
    }
}