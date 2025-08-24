class Solution {
    int gcd(int a , int b){
        if(b == 0)
            return Math.abs(a);
        return gcd(b , a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        int so = 0;
        int se = 0;
        for(int i = 1; i <= 2*n; i++){
            if(i%2 == 1)
                so += i;
            else
                se += i;
        }
        return gcd(se , so);
    }
}