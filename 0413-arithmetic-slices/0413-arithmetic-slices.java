class Solution {
    boolean allSame(List<Integer> l){
        int s = l.get(0);
        for(int i = 1; i < l.size(); i++){
            if(s != l.get(i))
                return false;
        }
        return true;
    }
    /*int solve(int[] nums){
        List<Integer> d = new ArrayList<>();
        for(int i = 0; i < nums.length-1; i++){
            d.add(nums[i+1]-nums[i]);
        }
        boolean[][] dp = new boolean[nums.length][nums.length];
        for(int l = 2; l <= nums.length-1; l++){
            for(int i = 0; i+l-1 < d.size(); i++){
                int j = i+l-1;
                if(i+1 == j && d.get(i) == d.get(j))
                dp[i][j] = true;
                else
                dp[i][j] = dp[i+1][j-1]&&(d.get(i) == d.get(j));
            }
        }
        int ans = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(dp[i][j])
                ans++;
            }
        }
        return ans;
    }*/
    public int numberOfArithmeticSlices(int[] nums) {
        List<Integer> d = new ArrayList<>();
        for(int i = 0; i < nums.length-1; i++){
            d.add(nums[i+1]-nums[i]);
        }
        int ans = 0;
        for(int i = 3; i <= nums.length; i++){
            int ws = i-1;
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j < ws; j++){
                l.add(d.get(j));
            }
            if(allSame(l))
                ans++;
            for(int j = ws; j < d.size(); j++){
                l.remove(0);
                l.add(d.get(j));
                if(allSame(l))
                    ans++;
            }
        }
        return ans;
        //return solve(nums);
    }
}