class Solution {
    public int minimizeXor(int num1, int num2) {
        int sbx = Integer.bitCount(num2);
        int x = 0;
        for(int i = 31; i >= 0 && sbx > 0; i--){
            if((num1&(1<<i)) != 0){
                x = x|(1<<i);
                sbx--;
            }
        }
        for(int i = 0; i <= 31 && sbx > 0; i++){
            if((x&(1<<i)) == 0){
                x = x|(1<<i);
                sbx--;
            }
        }
        return x;
    }
}