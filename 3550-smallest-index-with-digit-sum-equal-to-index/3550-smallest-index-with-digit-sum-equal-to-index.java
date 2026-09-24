class Solution {
    int sum(int n){
        int s = 0;
        for(int i = n; i > 0; i=i/10){
            int d = i%10;
            s += d;
        }
        return s;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(sum(nums[i]) == i)
                return i;
        }
        return -1;
    }
}