class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        int s = 0;
        for(int i = 0; i < piles.length; i++){
            pq.offer(new int[]{piles[i] , i});
            s += piles[i];
        }
        int r = 0;
        for(int i = 0; i < k; i++){
            int[] e = pq.poll();
            r += e[0]/2;
            pq.offer(new int[]{e[0]-(e[0]/2) , e[1]});
        }
        return s-r;
    }
}