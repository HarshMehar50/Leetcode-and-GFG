class Solution {
    int solve(String s , int[] digits , int i , int t){
        if(i == s.length())
        return 1;
        int ans = 0;
        int limit = digits[digits.length-1];
        if(t == 0)
        limit = s.charAt(i)-'0';
        for(int j = 0; j < digits.length && digits[j] <= limit; j++){
            int nt = 0;
            if(digits[j] < limit || t == 1)
            nt = 1;
            ans += solve(s , digits , i+1 , nt);
        }
        return ans;
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] d = new int[digits.length];
        for(int i = 0; i < digits.length; i++){
            d[i] = Integer.parseInt(digits[i]);
        }
        Arrays.sort(d);
        int ans = solve(Integer.toString(n) , d , 0 , 0);
        for(int i = 1; i < Integer.toString(n).length(); i++){
            ans += Math.pow(digits.length , i);
        }
        return ans;
    }
}