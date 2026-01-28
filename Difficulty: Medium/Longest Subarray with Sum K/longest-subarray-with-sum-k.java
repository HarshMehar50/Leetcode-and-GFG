// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int ans = 0;
        HashMap<Long , Integer> map = new HashMap<>();
        long ps = 0;
        map.put(0L , -1);
        for(int i = 0; i < arr.length; i++){
            ps += arr[i];
            if(map.containsKey(ps-k))
            ans = Math.max(ans , i-map.get(ps-k));
            //else
            map.putIfAbsent(ps , i);
        }
        return ans;
    }
}
