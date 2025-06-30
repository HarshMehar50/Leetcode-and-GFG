class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    public boolean isReachable(int targetX, int targetY) {
        if((targetX&(targetX-1)) == 0 || (targetY&(targetY-1)) == 0 || targetX == 1 || targetY == 1)
        return true;
        int g = gcd(targetX , targetY); 
        if(g == 1 || (g&(g-1)) == 0)
        return true;
        return false;
    }
}