class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 10;
        }else{
            List<Integer> dp = new ArrayList<>();
            dp.add(10);
            dp.add(81);
            for(int i = 2; i < n; i++){
                dp.add(dp.get(i-1)*(10-i));
            }
            int s = 0;
            for(int i = 0; i < dp.size(); i++){
                s += dp.get(i);
            }
            return s;
        }
    }
}