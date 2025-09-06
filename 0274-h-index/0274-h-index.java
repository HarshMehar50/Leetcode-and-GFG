class Solution {
    public int hIndex(int[] citations) {
        int max = 0;
        for(int i = 0; i < citations.length; i++){
            max = Math.max(max , citations[i]);
        }
        int[] f = new int[max+1];
        for(int i = 0; i < citations.length; i++){
            f[citations[i]]++;
        }
        for(int i = f.length-2; i >= 0; i--){
            f[i] += f[i+1];
        }
        for(int i = f.length-1; i >= 0; i--){
            if(f[i] >= i)
            return i;
        }
        return -1;
    }
}