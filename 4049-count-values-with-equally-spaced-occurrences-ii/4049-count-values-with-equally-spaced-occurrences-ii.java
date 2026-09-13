class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++){
            map.get(nums[i]).add(i);
        }
        int ans = 0;
        for(Integer x : map.keySet()){
            List<Integer> l = map.get(x);
            if(l.size() >= 3){
                boolean mark = true;
                for(int i = 0; i < l.size()-1; i++){
                    if(l.get(i+1)-l.get(i) != l.get(1)-l.get(0)){
                        mark = false;
                        break;
                    }
                }
                if(mark)
                ans++;
            }
        }
        return ans;
    }
}