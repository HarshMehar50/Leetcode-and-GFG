class Solution {
    int pivot(int arr[]){
        int s = 0;
        int e = arr.length-1;
        while(s < e){
            int m = s + (e-s)/2;
            if(arr[m] > arr[m+1] && m < e){
                return m;
            }
            if(arr[m-1] > arr[m] && s < m){
                return m-1;
            }
            if(arr[m] <= arr[s]){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        return -1;
    }
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.min(nums[0] , nums[1]);
        }else{
            int p = pivot(nums);
            if(p == nums.length-1)
                return nums[0];
            else
                return nums[p+1];
        }
    }
}