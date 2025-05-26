class Solution {
    public int integerBreak(int n) {
        if(n <= 3){
            return n-1;
        }
        int a = 1;
        while(n > 4){
            a = a*3;
            n = n-3;
        }
        a = a*n;
        return a;
    }
}