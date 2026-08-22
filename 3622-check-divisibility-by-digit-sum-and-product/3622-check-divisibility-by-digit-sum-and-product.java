class Solution {
    public boolean checkDivisibility(int n) {
        int s = 0;
        int p = 1;
        for(int i = n; i > 0; i = i/10){
            int d = i%10;
            s += d;
            p = p*d;
        }
        if(n%(s+p) == 0)
            return true;
        else
            return false;
    }
}