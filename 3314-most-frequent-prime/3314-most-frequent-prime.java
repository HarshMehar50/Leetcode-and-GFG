class Solution {
    int[] dR = {1 , 0 , -1 , 0 , 1 , 1 , -1 , -1};
    int[] dC = {0 , 1 , 0 , -1 , 1 , -1 , 1 , -1};
    HashMap<Integer , Integer> f;
    boolean prime(int n){
        if(n < 2)
        return false;
        if(n == 2 || n == 3 || n == 5)
        return true;
        if(n%2 == 0)
        return false;
        for(int i = 3; i*i <= n; i += 2){
            if(n%i == 0)
            return false;
        }
        return true;
    }
    void solve(int[][] mat , int i , int j , int k){
        int n = 0;
        while(i < mat.length && j < mat[0].length && i >= 0 && j >= 0){
            n = (n*10)+mat[i][j];
            if(prime(n) && n > 10)
            f.put(n , f.getOrDefault(n , 0)+1);
            i += dR[k];
            j += dC[k];
        }
    }
    public int mostFrequentPrime(int[][] mat) {
        f = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                for(int k = 0; k < 8; k++){
                    solve(mat , i , j , k);
                }
            }
        }
        int ans = -1;
        int max = 0;
        for(Integer x : f.keySet()){
            if(max < f.get(x) || (max == f.get(x) && ans < x)){
                max = f.get(x);
                ans = x;
            }
        }
        System.out.println(f);
        return ans;
    }
}