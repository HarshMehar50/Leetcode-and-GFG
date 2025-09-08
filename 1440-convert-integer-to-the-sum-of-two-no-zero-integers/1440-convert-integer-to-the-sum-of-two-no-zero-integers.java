class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i <= n; i++){
            String s1 = Integer.toString(i);
            String s2 = Integer.toString(n-i);
            if(!s1.contains("0") && !s2.contains("0"))
            return new int[]{i , n-i};
        }
        return new int[]{-1 , -1};
    }
}