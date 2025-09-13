class Solution {
    public int smallestAbsent(int[] nums) {
        int s = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
            max = Math.max(max , nums[i]);
        }
        double a = (double)((double)s/(double)nums.length);
        Arrays.sort(nums);
        for(int i = 1; i <= max; i++){
            if((double)i > a){
                int bs = Arrays.binarySearch(nums , i);
                if(bs < 0 || bs >= nums.length)
                    return i;
            }
        }
        return max+1;
    }
}