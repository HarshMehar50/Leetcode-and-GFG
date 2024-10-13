import java.util.Arrays;
class Solution {
    int sum(int a[]){
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }
    public int minSubArrayLen(int target, int[] nums) {
        if(sum(nums) < target){
            return 0;
        }
      int min = nums.length+1;
      int r = 0;
      int l = 0;
      int s = 0;
      while(r < nums.length && s < target){
        s += nums[r];
        if(s >= target){
            while(s >= target){
                s -= nums[l];
                min = Math.min(min , r-l+1);
                l++;
            }
        }
        r += 1;
      }
      if(min == nums.length+1)
      return 1;
      else
      return min;
    }
}   