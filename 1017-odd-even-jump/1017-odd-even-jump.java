class Solution {
    boolean solve(int[] arr , int i , int p , HashMap<Pair<Integer , Integer> , Boolean> dp){
        if(i == arr.length-1)
        return true;
        if(dp.containsKey(new Pair<>(i , p%2)))
        return dp.get(new Pair<>(i , p%2));
        boolean ans = false;
        if(p%2 == 1){
            int index1 = -1;
            int d = Integer.MAX_VALUE;
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] <= arr[j] && d > arr[j]-arr[i]){
                    d = arr[j]-arr[i];
                    index1 = j;
                }
            }
            if(index1 != -1)
            ans = ans||solve(arr , index1 , p+1 , dp);
        }else{
            int index2 = -1;
            int d = Integer.MAX_VALUE;
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] >= arr[j] && d > arr[i]-arr[j]){
                    d = arr[i]-arr[j];
                    index2 = j;
                }
            }
            if(index2 != -1)
            ans = ans||solve(arr , index2 , p+1 , dp);
        }
        dp.put(new Pair<>(i , p%2) , ans);
        return dp.get(new Pair<>(i , p%2));
    }
    /*
    int n = arr.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n - 1] = even[n - 1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);

        for (int i = n - 2; i >= 0; --i) {
            Map.Entry<Integer, Integer> oddJump = map.ceilingEntry(arr[i]); // Smallest >= arr[i]
            Map.Entry<Integer, Integer> evenJump = map.floorEntry(arr[i]);  // Largest <= arr[i]

            if (oddJump != null) {
                odd[i] = even[oddJump.getValue()];
            }
            if (evenJump != null) {
                even[i] = odd[evenJump.getValue()];
            }

            map.put(arr[i], i);
        }

        int count = 0;
        for (boolean b : odd) {
            if (b) count++;
        }
        return count;
    */ 
    int solve(int[] arr){
        TreeMap<Integer , Integer> map = new TreeMap<>();
        boolean[][] dp = new boolean[arr.length][2];
        dp[arr.length-1][1] = true;
        dp[arr.length-1][0] = true;
        map.put(arr[arr.length-1] , arr.length-1);
        for(int i = arr.length-2; i >= 0; i--){
            Integer odd = map.ceilingKey(arr[i]);
            Integer even = map.floorKey(arr[i]);
            if(odd != null)
            dp[i][1] = dp[map.get(odd)][0];
            if(even != null)
            dp[i][0] = dp[map.get(even)][1];
            map.put(arr[i] , i);
        }
        int ans = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i][1])
            ans++;
        }
        return ans;
    }
    public int oddEvenJumps(int[] arr) {
        /*int ans = 0;
        HashMap<Pair<Integer , Integer> , Boolean> dp = new HashMap<>();
        boolean v = solve(arr , 0 , 1 , dp);
        if(v)
        ans++;
        for(int i = 1; i < arr.length-1; i++){
            if(dp.containsKey(new Pair<>(i , 1))){
                if(dp.get(new Pair<>(i , 1)))
                ans++;
            }else{
                if(solve(arr , i , 1 , dp))
                ans++;
            }
        }
        if(arr.length == 1)
        return ans;
        else
        return ans+1;*/
        return solve(arr);
    }
}