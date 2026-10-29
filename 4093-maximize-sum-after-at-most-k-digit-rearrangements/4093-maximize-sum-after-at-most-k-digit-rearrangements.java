class Solution {
    class Pair{
        int n;
        long r;
        public Pair(int n , long r){
            this.n = n;
            this.r = r;
        } 
    }
    public long maximizeSum(int[] nums, int k) {
        long ans = 0;
        List<long[]> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            long n = 0;
            List<Integer> d = new ArrayList<>();
            for(int j = nums[i]; j > 0; j = j/10){
                d.add(j%10);
            }
            Collections.sort(d);
            for(int j = d.size()-1; j >= 0; j--){
                n = n*10 + d.get(j);
            }
            l.add(new long[]{nums[i] , n , n-nums[i]});
        }
        Collections.sort(l , (x , y)->Long.compare(y[2] , x[2]));
        for(int i = 0; i < l.size(); i++){
            if(i < k)
            ans += l.get(i)[1];
            else
            ans += l.get(i)[0];
        }
        return ans;
    }
}