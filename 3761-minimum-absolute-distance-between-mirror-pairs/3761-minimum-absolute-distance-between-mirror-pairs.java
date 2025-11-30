class Solution {
    int ceil(List<Integer> l , int x){
        int s = 0;
        int e = l.size()-1;
        int c = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m) < x)
            s = m+1;
            else{
                c = m;
                e = m-1;
            }
        }
        return c;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++){
            map.get(nums[i]).add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int r = 0;
            for(int j = nums[i]; j > 0; j = j/10){
                r = r*10 + j%10;
            }
            if(map.containsKey(r)){
                if(map.get(r).size() == 1){
                    if(map.get(r).get(0) > i)
                    ans = Math.min(ans , map.get(r).get(0)-i);
                }else{
                    int c = ceil(map.get(r) , i);
                    if(c != -1){
                        if(map.get(r).get(c) != i)
                        ans = Math.min(ans , map.get(r).get(c)-i);
                        else{
                            if(c+1 != map.get(r).size())
                            ans = Math.min(ans , map.get(r).get(c+1)-i);
                        }
                    }
                }
            }
        }
        if(ans == Integer.MAX_VALUE)
        return -1;
        else
        return ans;
    }
}