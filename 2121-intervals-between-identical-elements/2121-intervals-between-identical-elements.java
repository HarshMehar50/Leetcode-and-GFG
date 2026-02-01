class Solution {
    public long[] getDistances(int[] arr) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i] , new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            map.get(arr[i]).add(i);
        }
        long[] ans = new long[arr.length];
        HashMap<Integer , long[]> ps = new HashMap<>();
        for(Integer x : map.keySet()){
            List<Integer> l = map.get(x);
            long[] a = new long[l.size()];
            a[0] = l.get(0);
            for(int i = 1; i < a.length; i++){
                a[i] = a[i-1]+l.get(i);
            }
            ps.put(x , a);
        }
        //long[] ans = new long[arr.length]; 
        for(int i = 0; i < arr.length; i++){
            List<Integer> l = map.get(arr[i]);
            long[] a = ps.get(arr[i]);
            int eb = Collections.binarySearch(l , i);
            int ea = l.size()-eb-1;
            long sb = 0;
            if(eb != 0)
            sb = a[eb-1];
            long sa = a[a.length-1]-sb-i;
            ans[i] = (eb*(long)i)-sb + sa-(ea*(long)i);
        }
        return ans;
    }
}