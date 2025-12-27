class Solution {
    /*public static boolean special(int[] a , int s , int e){
        int c = 0;
        for(int i = s; i < e; i++){
            if((a[i]%2 == 0 && a[i+1]%2 != 0)||(a[i+1]%2 == 0 && a[i]%2 != 0))
                c++;
        }
        int a1 = e-s;
        if(c == a1)
            return true;
        else
            return false;
    }*/
    
    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        /*boolean[] b = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == queries[i][1])
                b[i] = true;
            else
                b[i] = special(nums , queries[i][0] , queries[i][1]);
        }
        return b;*/
        int[] dp = new int[nums.length];
        Arrays.fill(dp , 1);
        for(int i = 1; i < dp.length; i++){
            if(nums[i]%2 != nums[i-1]%2)
            dp[i] += dp[i-1];
        }
        List<int[]> l = new ArrayList<>();
        for(int i = 0; i < dp.length; i++){
            if(dp[i] == 1){
                if(i-1 >= 0){
                    int last = dp[i-1];
                    l.add(new int[]{i-last , i-1});
                }
            }
        }
        l.add(new int[]{dp.length-dp[dp.length-1] , dp.length-1});
        boolean[] ans = new boolean[queries.length];
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int[] a : l){
            map.put(a[0] , a[1]);
        }
        for(int i = 0; i < ans.length; i++){
            int s = map.floorKey(queries[i][0]);
            int e = map.get(s);
            if(s <= queries[i][0] && queries[i][1] <= e)
            ans[i] = true;
        }
        return ans;
    }
}