class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ws = 0;
        int c = 0;
        for(int i = 0; i < k; i++){
            ws += arr[i];
        }
        if(ws/k >= threshold)
            c++;
        for(int i = k; i < arr.length; i++){
            ws = ws - arr[i-k] + arr[i];
            if(ws/k >= threshold)
                c++;
        }
        return c;
    }
}