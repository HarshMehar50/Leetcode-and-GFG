class Solution {
    List<Integer> solve(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp , 1);
        int[] a = new int[nums.length];
        for(int i = 0; i < a.length; i++){
            a[i] = i;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]%nums[j] == 0 && 1+dp[j] > dp[i]){
                    dp[i] = 1+dp[j];
                    a[i] = j;
                }
            }
        }
        int max = -1;
        int maxi = -1;
        for(int i = 0; i < nums.length; i++){
            if(dp[i] > max){
                max = dp[i];
                maxi = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[maxi]);
        while(a[maxi] != maxi){
            maxi = a[maxi];
            ans.add(nums[maxi]);
        }
        Collections.reverse(ans);
        return ans;
    }
    /*int solve(int[] nums , int c , int p , List<Integer> a){
        if(c >= nums.length)
        return 0;
        int include = 0;
        if(p == -1 || (p != -1 && nums[c]%nums[p] == 0))
        include = 1+solve(nums , c+1 , c , a);
        int exclude = solve(nums , c+1 , p , a);
        if(include > exclude)
        a.add(nums[c]);
        int ans = Math.max(include , exclude);
        return ans;
    }*/
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        /*List<Integer> ans = new ArrayList<>();
        int l = solve(nums , 0 , -1 , ans);
        Collections.sort(ans);
        List<Integer> fans = new ArrayList<>();
        for(int i = 0; i < ans.size(); i++){
            if(!fans.contains(ans.get(i)))
            fans.add(ans.get(i));
        }
        return fans;*/
        List<Integer> ans = solve(nums);
        return ans;
    }
}