class Solution {
    void swap(int a , int b){
        int temp;
        temp = a;
        a = b; 
        b = temp;
    }
    int solveTab(int[] nums1 , int[] nums2){
        int[][] dp = new int[nums1.length+1][2];
        dp[nums1.length][0] = 0;
        dp[nums1.length][1] = 0;
        for(int i = nums1.length-1; i >= 1; i--){
            for(int j = 0; j <= 1; j++){
                int ans = Integer.MAX_VALUE;
                int p1 = (j == 1) ? nums2[i-1] : nums1[i-1];
                int p2 = (j == 1) ? nums1[i-1] : nums2[i-1];
                //if(j == 1)
                // swap(nums1[i-1] , nums2[i-1]);
        
                if(nums1[i] > p1 && nums2[i] > p2)
                ans = Math.min(dp[i+1][0] , ans);
        
                if(nums1[i] > p2 && nums2[i] > p1)
                ans = Math.min(ans , 1+dp[i+1][1]);
                dp[i][j] = ans;
            }
        }
        return dp[1][0];
    }
   /* int solveTab(int[] nums1, int[] nums2){
        int[][] dp = new int[nums1.length][2];
        dp[nums1.length-1][0] = 0;
        dp[nums1.length-1][1] = 1;
        for(int i = nums1.length-2; i >= 0; i--){
            dp[i][0] = dp[i][1] = Integer.MAX_VALUE;
            if(nums1[i] < nums1[i+1] && nums2[i] < nums2[i+1]){
                dp[i][0] = Math.min(dp[i][0] , dp[i+1][0]);
            }
            if(nums1[i] < nums2[i+1] && nums2[i] < nums1[i+1]){
                dp[i][0] = Math.min(dp[i][0] , dp[i+1][1]);
            }

             if (nums1[i] < nums1[i + 1] && nums2[i] < nums2[i + 1]) {
            dp[i][1] = Math.min(dp[i][1], dp[i + 1][0] + 1);
            }
             if (nums1[i] < nums2[i + 1] && nums2[i] < nums1[i + 1]) {
              dp[i][1] = Math.min(dp[i][1], dp[i + 1][1] + 1);
             }
        }
        return Math.min(dp[0][0] , dp[1][0]);
    }*/
    int solveTab1(int[] nums1 , int[] nums2){
        int n = nums1.length;
        
        int swap = 1; 
        int noSwap = 0; 
        
        for (int i = 1; i < n; i++) {
            int newSwap = n;
            int newNoSwap = n;
            
             if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                   newSwap = Math.min(newSwap, swap + 1);
                     newNoSwap = Math.min(newNoSwap, noSwap);
            }
            
              if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                  newSwap = Math.min(newSwap, noSwap + 1);
                
                     newNoSwap = Math.min(newNoSwap, swap);
            }
               swap = newSwap;
            noSwap = newNoSwap;
        }
          return Math.min(swap, noSwap);
    }
    int solve(int[] nums1 , int[] nums2 , int index , int swapped){
        if(index == nums1.length){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int p1 = nums1[index-1];
        int p2 = nums2[index-1];
        if(swapped == 1)
        swap(p1 , p2);
        
        if(nums1[index] > p1 && nums2[index] > p2)
            ans = solve(nums1 , nums2 , index+1 ,0);
        
        if(nums1[index] > p2 && nums2[index] > p1)
            ans = Math.min(ans , 1+solve(nums1 , nums2 , index+1 , 1));
        
        
        return ans;
    }
    public int minSwap(int[] nums1, int[] nums2) {
        /*int[] nums1m = new int[nums1.length+1];
        int[] nums2m = new int[nums2.length+1];
        nums1m[0] = -1;
        nums2m[0] = -1;
        for(int i = 0; i < nums1.length; i++){
            nums1m[i+1] = nums1[i];
            nums2m[i+1] = nums2[i];
        }
        return solve(nums1m , nums2m , 1 , 0);*/
        //return solveTab(nums1 , nums2);
        return solveTab1(nums1 , nums2);
    }
}