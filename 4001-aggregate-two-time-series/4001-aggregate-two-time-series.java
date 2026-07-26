class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        TreeMap<Integer , Integer> map1 = new TreeMap<>();
        TreeMap<Integer , Integer> map2 = new TreeMap<>();
        for(int[] a : series1){
            map1.put(a[0] , a[1]);
        }
        for(int[] a : series2){
            map2.put(a[0] , a[1]);
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        for(Integer x : map1.keySet()){
            map.put(x , 0);
        }
        for(Integer x : map2.keySet()){
            map.put(x , 0);
        }
        for(Integer x : map.keySet()){
            int v1 = 0;
            if(map1.ceilingKey(x) != null)
                v1 = map1.get(map1.ceilingKey(x));
            int v2 = 0;
            if(map2.ceilingKey(x) != null)
                v2 = map2.get(map2.ceilingKey(x));
            map.put(x , v1+v2);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Integer x : map.keySet()){
            List<Integer> inner = new ArrayList<>();
            inner.add(x);
            inner.add(map.get(x));
            ans.add(inner);
        }
        Collections.sort(ans , (x , y)->Integer.compare(x.get(0) , y.get(0)));
        return ans;
    }
}