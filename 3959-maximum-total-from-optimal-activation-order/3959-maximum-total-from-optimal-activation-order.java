class Solution {
    public long maxTotal(int[] value, int[] limit) {
        long ans = 0;
        TreeMap<Integer , List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < limit.length; i++){
            map.put(limit[i] , new ArrayList<>());
        }
        for(int i = 0; i < limit.length; i++){
            map.get(limit[i]).add(value[i]);
        }
        for(Integer x : map.keySet()){
            Collections.sort(map.get(x) , Collections.reverseOrder());
        }
        for(Integer x : map.keySet()){
            for(int i = 0; i < Math.min(x , map.get(x).size()); i++){
                ans += map.get(x).get(i);
            }
        }
        return ans;
    }
}