class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            f.put(arr[i] , f.getOrDefault(arr[i] , 0)+1);
        }
        int ans = -1;
        for(Integer x : f.keySet()){
            if(x == f.get(x))
            ans = Math.max(ans , x);
        }
        return ans;
    }
}