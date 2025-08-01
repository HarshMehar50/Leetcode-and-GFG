class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int pxor = 0;
        HashMap<Integer , Integer> f = new HashMap<>();
        f.put(0 , 1);
        long ans = 0;
        for(int i = 0; i < arr.length; i++){
            pxor = pxor^arr[i];
            int req = pxor^k;
            ans += f.getOrDefault(req , 0);
            f.put(pxor , f.getOrDefault(pxor , 0)+1);
        }
        return ans;
    }
}