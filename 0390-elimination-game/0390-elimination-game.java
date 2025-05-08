class Solution {
    public int lastRemaining(int n) {
        /*if(n == 1){
            return 1;
        }
        else if(n > 1 && n < 6){
            return 2;
        }
        else
        return ((n/2)-1)*2;*/
        if(n == 1){
            return 1;
        }
        else return 2*(1+n/2-lastRemaining(n/2));
    }
}