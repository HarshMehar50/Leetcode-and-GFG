class Solution {
    boolean solve(int[] nums , int k , int target , boolean[] visited , int[] subsetSum , int index , int lastIndex){
        if(subsetSum[index] == target){
            if(index == k-2){
                return true;
            }
            return solve(nums, k , target , visited , subsetSum , index+1 , nums.length-1);
        }
        for(int i = lastIndex; i >= 0; i--){
            if(visited[i]) continue;
            int temp = subsetSum[index]+nums[i];
            if(temp <= target){
                visited[i] = true;
                subsetSum[index] += nums[i];
                boolean next = solve(nums , k , target , visited , subsetSum , index , i-1);
                visited[i] = false;
                subsetSum[index] = subsetSum[index]-nums[i];
                if(next)
                    return true;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        /*int ts = 0;
        for(int i = 0; i < nums.length; i++){
            ts += nums[i];
        }
        if(ts%k != 0)
        return false;
        int ps = ts/k;
        int c = 0;
        for(int mask = 0; mask < (1<<nums.length); mask++){
            int s = 0;
            for(int i = 0; i < nums.length; i++){
                if((mask&(1<<i)) != 0)
                s += nums[i];
            }
            if(ps == s)
            c++;
        }
        if(c >= k)
        return true;
        else
        return false;*/
        if(k == 1){
            return true;
        }
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
        }
        boolean[] visited= new boolean[nums.length];
        Arrays.fill(visited , false);
        int[] subsetSum = new int[k];
        Arrays.fill(subsetSum , 0);
        visited[nums.length-1] = true;
        subsetSum[k-1] = nums[nums.length-1];
        if(s%k == 0){
            return solve(nums , k , s/k , visited , subsetSum , 0 , nums.length-1);
        }else{
            return false;
        }
    }
}