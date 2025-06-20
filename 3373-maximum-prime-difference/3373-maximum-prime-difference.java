class Solution {
    boolean[] seive(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime , true);
        for(int j = 2; j*j <= n; j++){
            if(prime[j]){
                for(int i = j*j; i <= n; i += j){
                    prime[i] = false;
                }
            }
        }
        return prime;
    }
    public int maximumPrimeDifference(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        int fi = 0;
        int li = 0;
        boolean[] prime = seive(max);
        for(int i = 0; i < nums.length; i++){
            if(prime[nums[i]]){
                fi = i;
                break;
            }
        }
        for(int i = nums.length-1; i >= 0; i--){
            if(prime[nums[i]]){
                li = i;
                break;
            }
        }
        return Math.abs(li-fi);
    }
}