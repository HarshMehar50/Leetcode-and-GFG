// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int floor(int[] a , int x){
        int s = 0;
        int e = a.length-1;
        int f = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] <= x){
                f = m;
                s = m+1;
            }else
            e = m-1;
        }
        return f;
    }
    static int ceil(int[] a , int x){
        int s = 0;
        int e = a.length-1;
        int c = a.length;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] < x)
            s = m+1;
            else{
                c = m;
                e = m-1;
            }
        }
        return c;
    }
    static int countTriangles(int arr[]) {
        // code here
        /*Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                int h = arr[i]+arr[j];
                int l = Math.abs(arr[i]-arr[j]);
                int f = floor(arr , h);
                int c = ceil(arr , l);
                c = Math.min(c , arr.length-1);
                f = Math.max(0 , f);
                if(f-c >= 0)
                ans += (f-c+1);
            }
        }
        return ans;*/
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}