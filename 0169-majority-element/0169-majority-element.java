class Solution {
    public int majorityElement(int[] nums) {
        int c = 0;
        int e = -1;
        for(int i = 0; i < nums.length; i++){
            if(c == 0){
            e = nums[i];
            c = 1;
            }else if(e == nums[i])
            c++;
            else
            c--;
        }
        return e;
    }
}