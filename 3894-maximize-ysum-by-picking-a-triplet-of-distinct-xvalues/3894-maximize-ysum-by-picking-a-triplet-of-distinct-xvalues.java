class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < x.length; i++){
            map.put(x[i] , 0);
        }
        for(int i = 0; i < x.length; i++){
            int v = map.get(x[i]);
            map.put(x[i] , Math.max(v , y[i]));
        }
        List<Integer> l = new ArrayList<>();
        if(map.size() < 3)
            return -1;
        for(Integer a : map.keySet()){
            l.add(map.get(a));
        }
        Collections.sort(l);
        int ans = l.get(l.size()-1)+l.get(l.size()-2)+l.get(l.size()-3);
        return ans;
    }
}