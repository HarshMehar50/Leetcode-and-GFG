class Solution {
    int ceil(int[] a , int t){
        int s = 0;
        int e = a.length-1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] > t)
                e = m-1;
            else
                s = m+1;
        }
        return s;
    }
    int solve(int[] arr1 , int[] arr2 , int c , int p , HashMap<Pair<Integer , Integer> , Integer> dp){
        if(c >= arr1.length)
            return 0;
        if(dp.containsKey(new Pair<>(c , p)))
            return dp.get(new Pair<>(c , p));
        int exclude = (int)(1e9)+1;
        int include = (int)(1e9)+1;
        if(arr1[c] > p)
            exclude = solve(arr1 , arr2 , c+1 , arr1[c] , dp);
        int index = ceil(arr2 , p);
        if(index != arr2.length)
            include = 1+solve(arr1 , arr2 , c+1 , arr2[index] , dp);
        int ans = Math.min(include , exclude);
        dp.put(new Pair<>(c , p) , ans);
        return dp.get(new Pair<>(c , p));
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        HashMap<Pair<Integer , Integer> , Integer> dp = new HashMap<>();
        int ans = solve(arr1 , arr2 , 0 , -1 , dp);
        if(ans == (int)(1e9)+1)
            return -1;
        else
            return ans;
    }
}