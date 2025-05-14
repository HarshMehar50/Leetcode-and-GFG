class Solution {
    public int climbStairs(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        for(int i = 3; i < n+1; i++){
            list.add(list.get(i-1)+list.get(i-2));
        }
        return list.get(n);
    }
}