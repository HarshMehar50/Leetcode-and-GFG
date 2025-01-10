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
    public int sumSubarrayMins(int[] arr) {
        int[] nsli = NSL(arr);
        int[] nsri = NSR(arr);
        long ans = 0;
        for(int i = 0; i < arr.length; i++){
            long d = (Math.abs(nsli[i]-i)*Math.abs(nsri[i]-i))%mod;
            long v = (d*arr[i])%mod;
            ans = (ans+v)%mod;
        }
        return (int)ans;
    }
}