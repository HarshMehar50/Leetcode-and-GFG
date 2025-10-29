class Solution {
    public int smallestNumber(int n) {
        int l = (int)(Math.log(n)/Math.log(2))+1;
        return (1<<l)-1;
    }
}