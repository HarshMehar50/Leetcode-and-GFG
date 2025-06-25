class Solution {
    static int majorityElement(int arr[]) {
        // code here
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            f.put(arr[i] , f.getOrDefault(arr[i] , 0)+1);
        }
        for(Integer x : f.keySet()){
            if(f.get(x) > arr.length/2)
            return x;
        }
        return -1;
    }
}