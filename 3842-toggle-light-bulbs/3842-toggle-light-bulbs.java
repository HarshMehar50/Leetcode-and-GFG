class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer , Integer> f = new TreeMap<>();
        for(Integer x : bulbs){
            f.put(x , f.getOrDefault(x , 0)+1);
        }
        for(Integer x : f.keySet()){
            if(f.get(x)%2 == 1)
            ans.add(x);
        }
        return ans;
    }
}