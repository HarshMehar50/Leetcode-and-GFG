class Solution {
    int missingNum(int arr[]) {
        // code here
        long s = 0;
        for(int i = 0; i < arr.length; i++){
            s += arr[i];
        }
        long n = arr.length+1;
        long t = n*(n+1)/2;
        return (int)(t-s);
    }
}