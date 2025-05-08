class Solution {
    int recursion(int n , int k){
        if(n == 1){
            return 0;
        }
        return (recursion(n-1 , k)+k)%n;
    }
    public int findTheWinner(int n, int k) {
        int a = recursion(n , k);
        return a+1;
    }
}