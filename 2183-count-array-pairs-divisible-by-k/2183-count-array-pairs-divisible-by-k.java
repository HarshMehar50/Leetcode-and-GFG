class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    public long countPairs(int[] nums, int k) {
        long ans = 0;
        /*int[] f = new int[k];
        for(int i = 0; i < nums.length; i++){
            f[nums[i]%k]++;
        }
        for(int i = 0; i < nums.length; i++){
            int r = nums[i]%k;
            int g = gcd(r , k);
            int base = k/g;
            for(int j = 1; j*base < k; j++){
                ans += f[j*base];
            }
        }*/
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int g = gcd(nums[i] , k);
            f.put(g ,  f.getOrDefault(g , 0)+1);
        }
        for(Integer x : f.keySet()){
            for(Integer y : f.keySet()){
                if((long)((long)x*(long)y)%k == 0){
                    if(x == y)
                    ans += (long)((long)f.get(x)*(long)(f.get(x)-1))/2;
                    else if(x < y)
                    ans += (long)((long)f.get(x)*(long)f.get(y));
                }
            }
        }
        return ans;
    }
}