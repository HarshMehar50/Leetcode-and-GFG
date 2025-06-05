class Solution {
    int solve(int[] nums , int d , int index){
        if(index < 0){
            return 0;
        }
        int ans = 0;
        for(int j = index-1; j >= 0; j--){
            if(nums[index]-nums[j] == d){
                ans = Math.max(ans , 1+solve(nums , d , j));
            }
        }
        return ans;
    }
    int solveTab(int[] nums){
       /* if(nums.length <= 2){
            return nums.length
        }
        int ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                int d = nums[i]-nums[j];
                int c = 1;
            }
        }*/
        int count = 2;
        int len = nums.length;
        int[][] dp = new int[len][2000];
        for (int[] i : dp) {
            Arrays.fill(i, 0);
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = nums[j] - nums[i] + 1000;
                dp[j][diff] = Math.max(2, dp[i][diff] + 1);
                count = Math.max(count, dp[j][diff]);
            }
        }
        return count;
    }
    public int longestArithSeqLength(int[] nums) {
        /*if(nums.length <= 2){
            return nums.length;
        }
        int ans = 0;
        int[][] dp = new int[nums.length][2000];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                ans = Math.max(ans , 2+solve(nums , nums[j]-nums[i] , i));
            }
        }
        return ans;*/
        return solveTab(nums);
    }
}