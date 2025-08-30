class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] f = new int[10];
        for(int i = n; i > 0; i = i/10){
            int d = i%10;
            f[d]++;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < f.length; i++){
            if(f[i] != 0)
            min = Math.min(f[i] , min);
        }
        int ans = -1;
        for(int i = 0; i < f.length; i++){
            if(f[i] == min){
                ans = i;
                break;
            }
        }
        return ans;
    }
}