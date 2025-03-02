class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i][0] , new ArrayList<>());
        }
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i][0] , new ArrayList<>());
        }
        for(int i = 0; i < nums1.length; i++){
            map.get(nums1[i][0]).add(nums1[i][1]);
        }
        for(int i = 0; i < nums2.length; i++){
            map.get(nums2[i][0]).add(nums2[i][1]);
        }
        List<int[]> l = new ArrayList<>();
        for(Integer x : map.keySet()){
            int s = 0;
            for(int i = 0; i < map.get(x).size(); i++){
                s += map.get(x).get(i);
            }
            l.add(new int[]{x , s});
        }
        int[][] ans = new int[l.size()][2];
        for(int i = 0; i < l.size(); i++){
            ans[i][0] = l.get(i)[0];
            ans[i][1] = l.get(i)[1];
        }
        Arrays.sort(ans , (x , y)->Integer.compare(x[0] , y[0]));
        return ans;
    }
}