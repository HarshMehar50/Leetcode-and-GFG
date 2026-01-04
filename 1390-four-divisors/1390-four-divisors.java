class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int s = 0;
            int c = 0;
            for(int j = 1; j*j <= nums[i]; j++){
                if(nums[i]%j == 0){
                    c++;
                    s += j;
                    if(j != nums[i]/j){
                        s += nums[i]/j;
                        c++;
                    }
                }
            }
            if(c == 4)
            ans += s;
        }
        return ans;
    }
}