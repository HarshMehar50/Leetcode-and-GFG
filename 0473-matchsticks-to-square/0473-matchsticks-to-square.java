class Solution {
    boolean solve(int[] matchsticks , int k , int target , int index , int lastIndex , boolean[] visited , int[] subsetSum){
        int n = matchsticks.length;
        if(subsetSum[index] == target){
            if(index == k-2){
                return true;
            }
            return solve(matchsticks , k , target , index+1 , n-1 , visited , subsetSum);
        }
        for(int i = lastIndex ; i >= 0; i--){
            if(visited[i]) continue;
            int temp = subsetSum[index] + matchsticks[i];
            if(temp <= target){
                visited[i] = true;
                subsetSum[index] += matchsticks[i];
                boolean next = solve(matchsticks , k , target , index , i-1 , visited , subsetSum);
                visited[i] = false;
                subsetSum[index] = subsetSum[index]-matchsticks[i];
                if(next){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int s = 0;
        for(int i = 0; i < n; i++){
            s += matchsticks[i];
        }
        boolean[] visited = new boolean[n];
        Arrays.fill(visited , false);
        int[] subsetSum = new int[4];
        Arrays.fill(subsetSum , 0);
        visited[n-1] = true;
        subsetSum[3] = matchsticks[n-1];
        if(s%4 == 0){
            return solve(matchsticks , 4 , s/4 , 0 , n-1 , visited , subsetSum);
        }else{
            return false;
        }
    }
}