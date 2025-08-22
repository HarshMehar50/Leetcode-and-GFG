class Solution {
    int floor(int[] a , int x){
        int s = 0;
        int e = a.length-1;
        int f = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] <= x){
                f = m;
                s = m+1;
            }else
            e = m-1;
        }
        return f;
    }
    int count(int[] nums , int k , int m){
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int f = floor(nums , nums[i]+m);
            if(f != -1)
            ans += f-i;
        }
        return ans;
    }
    int count(int[] nums , int m){
        int ans = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && nums[j]-nums[i] <= m){
                j++;
            }
            ans += j-i-1;
        }
        return ans;
    }
    public int smallestDistancePair(int[] nums, int k) {
        int s = 0;
        int e = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min , nums[i]);
            max = Math.max(max , nums[i]);
        }
        e = Math.abs(max-min);
        Arrays.sort(nums);
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            /*int c = count(nums , k , m);
            if(c <= k){
                ans = m;
                s = m+1;
            }else{
                e = m-1;
            }*/
            int c = count(nums , m);
            if(c >= k){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}