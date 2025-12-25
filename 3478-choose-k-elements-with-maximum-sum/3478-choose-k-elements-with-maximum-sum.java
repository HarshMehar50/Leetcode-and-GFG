class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        long[] ans = new long[nums1.length];
        int[][] a = new int[nums1.length][3];
        for(int i = 0; i < a.length; i++){
            a[i][0] = nums1[i];
            a[i][1] = nums2[i];
            a[i][2] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int j = 0;
        long s = 0;
        for(int i = 0; i < a.length; i++){
            while(j < i && a[j][0] < a[i][0]){
                s += a[j][1];
                pq.offer(new int[]{a[j][1] , j});
                j++;
            }
            while(pq.size() > k){
                s -= pq.peek()[0];
                pq.poll();
            }
            ans[a[i][2]] = s;
        }
        return ans;
    }
}