class Solution {
    public int addDigits(int num) {
        while(num >= 10){
            int s = 0;
            for(int i = num; i > 0; i = i/10){
                s += i%10;
            }
            num = s;
        }
        return num;
    }
}