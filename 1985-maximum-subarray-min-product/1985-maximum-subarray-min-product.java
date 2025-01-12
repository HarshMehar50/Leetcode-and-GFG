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
    final int mod = 1000000007;
    public int maxSumMinProduct(int[] nums) {
        long[] p = new long[nums.length];
        p[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            p[i] = p[i-1]+nums[i];
        }
        int[] nsli = NSL(nums);
        int[] nsri = NSR(nums);
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
        int min = nums[i];
        int li = (nsli[i] == -1) ? 0 : nsli[i]+1;
        int ri = (nsri[i] == nums.length) ? nums.length-1 : nsri[i]-1;
        long sum = (li == 0) ? p[ri] : (p[ri] - p[li - 1]);
        ans = Math.max(ans , (sum*min));
        }
        return (int)(ans%mod);
    }
}