class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < 3; i++){
            map.put(i , new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++){
            map.get(nums[i]%3).add(nums[i]);
        }
        for(int i = 0; i < 3; i++){
            Collections.sort(map.get(i));
        }
        int o0 = 0;
        if(map.get(0).size() >= 3)
        o0 = map.get(0).get(map.get(0).size()-1)+map.get(0).get(map.get(0).size()-2)+map.get(0).get(map.get(0).size()-3);

        int o1 = 0;
        if(map.get(1).size() >= 3)
        o1 = map.get(1).get(map.get(1).size()-1)+map.get(1).get(map.get(1).size()-2)+map.get(1).get(map.get(1).size()-3);

        int o2 = 0;
        if(map.get(2).size() >= 3)
        o2 = map.get(2).get(map.get(2).size()-1)+map.get(2).get(map.get(2).size()-2)+map.get(2).get(map.get(2).size()-3);

        int o012 = 0;
        if(!map.get(0).isEmpty() && !map.get(1).isEmpty() && !map.get(2).isEmpty())
        o012 = map.get(0).get(map.get(0).size()-1)+map.get(1).get(map.get(1).size()-1)+map.get(2).get(map.get(2).size()-1);

        return Math.max(Math.max(o0 , o1) , Math.max(o2 , o012));
    }
}