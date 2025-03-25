class Solution {
    public double myPow(double x, int n) {
       /*List<Double> dp = new ArrayList<>();
       dp.add(1.0);
       if(n > 0 && (x > 0.05 || x < 0)){
       for(int i = 1; i < n+1; i++){
        dp.add(dp.get(i-1)*x);
       }
       return dp.get(dp.size()-1);
       }
       
       else if(n < 0){
        n = (int)Math.abs(n);
        for(int i = 1; i < n+1; i++){
            dp.add(dp.get(i-1)/x);
        }
        return dp.get(dp.size()-1);
       }
       else if( x <= 0.0001 && x >= 0 && n >= 20000000){
        return 0.0;
       }
       else{
        return 1.0;
       }*/
       if(n < 0){
            n = -n;
            x = 1 / x;
        }
        double pow = 1;
        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            }   
            x *= x;
            n >>>= 1;    
        }
        return pow;
    }
}