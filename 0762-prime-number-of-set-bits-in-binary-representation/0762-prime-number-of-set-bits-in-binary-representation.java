class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] p = new boolean[33];
        Arrays.fill(p , true);
        for(int i = 2; i <= 32; i++){
            if(p[i]){
                for(int j = i*i; j <= 32; j += i){
                    p[j] = false;
                }
            }
        }
        p[0] = false;
        p[1] = false;
        int ans = 0;
        for(int i = left; i <= right; i++){
            if(p[Integer.bitCount(i)])
            ans++;
        }
        return ans;
    }
}