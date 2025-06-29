class Solution {
    // Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int k) {
        // your code here,return the answer
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            f.put(arr[i] , f.getOrDefault(arr[i] , 0)+1);
        }
        int ans = 0;
        for(Integer x : f.keySet()){
            if(f.get(x) > arr.length/k)
            ans++;
        }
        return ans;
    }
}