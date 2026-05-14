class Solution {
    boolean predicate(int[][] tasks , int m){
        for(int[] t : tasks){
            if(t[1] > m)
            return false;
            m -= t[0];
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int s = 0;
        int s0 = 0;
        int s1 = 0;
        for(int[] t : tasks){
            s0 += t[0];
            s1 += t[1];
        }
        int e = Math.max(s0 , s1);
        Arrays.sort(tasks , (x , y)->Integer.compare(y[1]-y[0] , x[1]-x[0]));
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(tasks , m)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}