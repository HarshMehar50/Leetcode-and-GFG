class Solution {
    int ceil(int[] a , int x){
        int s = 0;
        int e = a.length-1;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] < x)
                s = m+1;
            else{
                ans = m;
                e = m-1;
            }
        }
        return ans;
    }
    int floor(int[] a , long x){
        int s = 0;
        int e = a.length-1;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] <= x){
                ans = m;
                s = m+1;
            }else
                e = m-1;
        }
        return ans;
    }
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int min = nums[i];
            long max = (long)((long)k*(long)min);
            int c = floor(nums , max);
            if(c == -1)
                c = i-1;
            int rl = i;
            int rr = nums.length-(c+1);
            ans = Math.min(ans , rl+rr);
        }
        return ans;
    }
}