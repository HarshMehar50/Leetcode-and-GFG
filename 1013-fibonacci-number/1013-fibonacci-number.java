class Solution {
    public int fib(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);
        for(int i = 2; i < n+1; i++){
            dp.add(dp.get(i-1)+dp.get(i-2));
        }
        return dp.get(n);
    }
}