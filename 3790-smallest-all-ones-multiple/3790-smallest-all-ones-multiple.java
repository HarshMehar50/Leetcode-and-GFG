class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2 == 0 || k%5 == 0)
        return -1;
        int r = 1%k;
        int ans = 1;
        
        Set<Integer> set = new HashSet<>();
        set.add(r);
        while(r != 0){
            r = (r*10 + 1)%k;
            if(set.contains(r))
            return -1;
            set.add(r);
            ans++;
        }
        return ans;
    }
}