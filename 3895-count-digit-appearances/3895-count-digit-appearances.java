class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = nums[i]; j > 0; j = j/10){
                if(j%10 == digit)
                    ans++;
            }
        }
        return ans;
    }
}