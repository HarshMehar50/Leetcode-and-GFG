class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] a = new int[k];
        int[] amin = new int[k];
        Arrays.fill(amin , Integer.MAX_VALUE);
        for(int i = 0; i < energy.length; i++){
            amin[i%k] = Math.min(amin[i%k] , a[i%k]);
            a[i%k] += energy[i];
            //amin[i%k] = Math.min(amin[i%k] , a[i%k]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++){
            ans = Math.max(ans , a[i]-amin[i]);
        }
        return ans;
    }
}