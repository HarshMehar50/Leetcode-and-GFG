// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        /*int[][] a = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            a[i][0] = arr[i];
            a[i][1] = dep[i];
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[1] , y[1]));
        int ans = 0;
        List<int[]> l = new ArrayList<>();
        l.add(new int[]{a[0][0] , a[0][1] , 1});
        for(int i = 1; i < a.length; i++){
            if(a[i][0] <= l.get(l.size()-1)[1]){
            l.get(l.size()-1)[1] = a[i][1];
            l.get(l.size()-1)[2]++;
            }else
            l.add(new int[]{a[i][0] , a[i][1] , 1});
        }
        for(int i = 0; i < l.size(); i++){
            ans = Math.max(ans , l.get(i)[2]);
        }
        return ans;*/
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int platforms = 0, maxPlatforms = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else {
                platforms--;
                j++;
            }
        }

    return maxPlatforms;
    }
}
