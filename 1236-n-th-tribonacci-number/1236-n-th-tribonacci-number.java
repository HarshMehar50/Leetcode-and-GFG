class Solution {
    public int tribonacci(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);
        dp.add(1);
        for(int i = 3; i < n+1; i++){
            dp.add(dp.get(i-1)+dp.get(i-2)+dp.get(i-3));
        }
        return dp.get(n);
    }
}