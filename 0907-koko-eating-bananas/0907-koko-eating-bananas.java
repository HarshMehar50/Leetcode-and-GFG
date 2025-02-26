class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            e = Math.max(piles[i] , e);
        }
        while(s < e){
            int m = s+(e-s)/2;
            int h1 = 0;
            for(int i = 0; i < piles.length; i++){
                if(piles[i]%m == 0)
                h1 += piles[i]/m;
                else
                h1 += piles[i]/m + 1;
            }
            if(h1 <= h)
            e = m;
            else
            s = m+1;
        }
        return s;
    }
}