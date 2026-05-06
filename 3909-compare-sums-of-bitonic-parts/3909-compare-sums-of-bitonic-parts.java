class Solution {
    public int compareBitonicSums(int[] nums) {
        int pi = -1;
        for(int i = 1; i < nums.length-1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                pi = i;
                break;
            }
        }
        long s1 = 0;
        long s2 = 0;
        for(int i = 0; i <= pi; i++){
            s1 += nums[i];
        }
        for(int i = pi; i < nums.length; i++){
            s2 += nums[i];
        }
        if(s1 > s2)
        return 0;
        else if(s2 > s1)
        return 1;
        else
        return -1;
    }
}