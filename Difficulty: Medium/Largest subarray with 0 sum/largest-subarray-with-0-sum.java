class Solution {
    int maxLength(int arr[]) {
        // code here
        HashMap<Long , Integer> map = new HashMap<>();
        long ps = 0;
        map.put(0L , -1);
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            //if(arr[i] >= 0)
            ps += arr[i];
            if(map.containsKey(ps))
            ans = Math.max(ans , i-map.get(ps));
            else
            map.put(ps , i);
        }
        return ans;
    }
}