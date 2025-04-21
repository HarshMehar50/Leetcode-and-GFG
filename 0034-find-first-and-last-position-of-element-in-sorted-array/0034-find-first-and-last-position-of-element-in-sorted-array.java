class Solution {
    /* boolean AllEqual(int arr[] , int x , int start , int end){
        int c = 0;
        for(int i = start ; i <= end; i++){
            if(arr[i] == x)
            c++;
        }
        if(c == (end-start)+1)
        return true;
        else
        return false;
    }*/
    int ModifiedBS (int[] arr , int t , int start , int end){
        int s = start;
        int e = end;
        while(s <= e){
            int m = s + (e-s)/2;
            if(arr[m] == t){
                return m;
            }
            if(t > arr[m]){
                s = m+1;
            }
            else{
                e = m-1;
            }
        }
        return -1;
    }
    int CountBack(int a[] , int x , int start){
        int cb = 0;
        for(int i = start-1; i >= 0; i--){
            if(a[i] == x)
                cb++;
        }
        return cb;
    }
    int CountForward(int a[]  , int x , int start){
        int cf = 0;
        for(int i = start+1; i < a.length; i++){
            if(a[i] == x)
                cf++;
        }
        return cf;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1 , -1};
        int k = ModifiedBS(nums , target , 0 , nums.length-1);
       /* int start = ModifiedBS(nums , target , 0 , k-1);
        int end = ModifiedBS(nums , target , k+1 , nums.length-1);
        if(start == -1 && k != -1){
            start = k;
        }
        if(end == -1 && k != -1){
            end = k;
        }
        if(AllEqual(nums , target , k+1 , nums.length-1)){
            end = nums.length-1;
        }*/
        int start = k-CountBack(nums , target , k);
        int end = k+CountForward(nums , target , k);
        if(k != -1)
            ans = new int[]{start , end};
        else
            ans = new int[]{-1 , -1};
        return ans;
    }
}