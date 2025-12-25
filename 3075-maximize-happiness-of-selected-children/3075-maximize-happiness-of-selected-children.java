class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        Arrays.sort(happiness);
        for(int i = happiness.length-1; i >= happiness.length-k; i--){
            ans += Math.max(0 , happiness[i]-(happiness.length-1-i));
        }
        return ans;
    }
}