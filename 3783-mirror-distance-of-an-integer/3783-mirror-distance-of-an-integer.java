class Solution {
    public int mirrorDistance(int n) {
        int r = 0;
        for(int i = n; i > 0; i = i/10){
            int d = i%10;
            r = r*10 + d;
        }
        return Math.abs(r-n);
    }
}