class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int c = 0;
        for(int i = 0; i < nums.length-1; i++){
            if((nums[i]%2 == 0 && nums[i+1]%2 != 0)||(nums[i+1]%2 == 0 && nums[i]%2 != 0))
                c++;
        }
        if(c == nums.length-1)
            return true;
        else
            return false;
    }
}