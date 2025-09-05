class Solution {
    boolean possible(long n , int x){
        if(Long.bitCount(n) <= x && x <= Long.bitCount(-n))
        return true;
        else
        return false;
    }
    public int makeTheIntegerZero(int num1, int num2) {
        /*Queue<long[]> q = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        q.offer(new long[]{num1 , 0});
        visited.add((long)num1);
        while(!q.isEmpty()){
            long node = q.peek()[0];
            long ops = q.peek()[1];
            q.poll();
            if(node == 0)
            return (int)ops;
            for(int i = 0; i <= 60; i++){
                long nn = (long)((long)(1L<<i)+(long)num2);
                if(!visited.contains(nn)){
                    q.offer(new long[]{nn , ops+1});
                    visited.add(nn);
                }
            }
        }
        return -1;*/
        for(int i = 0; i <= 60; i++){
            long x = (long)num1-(long)((long)i*(long)num2);
            if(possible(x , i))
            return i;
        }
        return -1;
    }
}