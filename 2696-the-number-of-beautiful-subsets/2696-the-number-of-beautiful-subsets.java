class Solution {
    int BS(List<Integer> l , int x){
        int s = 0;
        int e = l.size()-1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m) == x)
            return m;
            if(l.get(m) < x)
            s = m+1;
            else
            e = m-1;
        }
        return -1;
    }
    boolean check(List<Integer> l , int k){
        for(int i = 0; i < l.size(); i++){
            if(BS(l , l.get(i)+k) != -1 || BS(l , l.get(i)-k) != -1)
            return false;
        }
        return true;
    }
    public int beautifulSubsets(int[] nums, int k) {
        int ans = 0;
        for(int mask = 1; mask < (1<<nums.length); mask++){
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if((mask&(1<<i)) != 0)
                l.add(nums[i]);
            }
            if(check(l , k))
            ans++;
        }
        return ans;
    }
}