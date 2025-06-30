// User function Template for Java

class Solution {
    public int findMaximum(int[] arr) {
        // code here
        int s = 0;
        int e = arr.length-1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(arr[m] > arr[m-1] && arr[m] > arr[m+1])
            return arr[m];
            if(arr[m] < arr[m+1])
            s = m+1;
            else
            e = m-1;
        }
        return -1;
    }
}