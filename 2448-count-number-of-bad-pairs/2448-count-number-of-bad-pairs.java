class Solution {
    public long countBadPairs(int[] nums) {
        int[] a = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            a[i] = nums[i]-i;
        }
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            f.put(a[i] , 0);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int v = f.get(a[i]);
            f.put(a[i] , v+1);
        }
        long r = 0;
        for(Integer x : f.keySet()){
            if(f.get(x) > 1)
            r += (long)((long)f.get(x)*(f.get(x)-1)/2);
        }
        long t = (long)nums.length*(nums.length-1)/2;
        long ans =  t - r;
        return ans;
    }
}