class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int[] a = {0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9};
        List<Integer> l = new ArrayList<>();
        while(sum != 0){
            for(int i = 9; i >= 0; i--){
                if(a[i] <= sum){
                    sum -= a[i];
                    l.add(a[i]);
                    break;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(Integer x : l){
            ans.append((char)('0'+x));
        }
        if(ans.length() > num)
            return "";
        if(ans.length() < num){
            int r = num-ans.length();
            for(int i = 0; i < r; i++){
                ans.append('0');
            }
        }
        return ans.toString();
    }
}