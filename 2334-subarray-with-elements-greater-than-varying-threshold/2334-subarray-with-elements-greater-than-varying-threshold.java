class Solution {
    int[] NSL(int[] arr){
        int[] nsli = new int[arr.length];
        Stack<int[]> s = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(s.isEmpty())
            nsli[i] = -1;
            else{
                while(!s.isEmpty() && s.peek()[0] >= arr[i]){
                    s.pop();
                }
                if(s.isEmpty())
                nsli[i] = -1;
                else
                nsli[i] = s.peek()[1];
            }
            s.push(new int[]{arr[i] , i});
        }
        return nsli;
    }
    int[] NSR(int[] arr){
        int[] nsri = new int[arr.length];
        Stack<int[]> s = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            if(s.isEmpty())
            nsri[i] = arr.length;
            else{
                while(!s.isEmpty() && s.peek()[0] > arr[i]){
                    s.pop();
                }
                if(s.isEmpty())
                nsri[i] = arr.length;
                else
                nsri[i] = s.peek()[1];
            }
            s.push(new int[]{arr[i] , i});
        }
        return nsri;
    }
    public int validSubarraySize(int[] nums, int threshold) {
        int[] nsli = NSL(nums);
        int[] nsri = NSR(nums);
        for(int i = 0; i < nums.length; i++){
            int li = nsli[i]+1;
            int ri = nsri[i]-1; 
            int k = ri-li+1;
            if(nums[i] > threshold/k)
            return k;
        }
        return -1;
    }
}