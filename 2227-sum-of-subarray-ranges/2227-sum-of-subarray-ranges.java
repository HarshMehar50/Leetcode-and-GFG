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
    int[] NLL(int[] arr){
        int[] nlli = new int[arr.length];
        Stack<int[]> s = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(s.isEmpty())
            nlli[i] = -1;
            else{
                while(!s.isEmpty() && s.peek()[0] <= arr[i]){
                    s.pop();
                }
                if(s.isEmpty())
                nlli[i] = -1;
                else
                nlli[i] = s.peek()[1];
            }
            s.push(new int[]{arr[i] , i});
        }
        return nlli;
    }
    int[] NLR(int[] arr){
        int[] nlri = new int[arr.length];
        Stack<int[]> s = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            if(s.isEmpty())
            nlri[i] = arr.length;
            else{
                while(!s.isEmpty() && s.peek()[0] < arr[i]){
                    s.pop();
                }
                if(s.isEmpty())
                nlri[i] = arr.length;
                else
                nlri[i] = s.peek()[1];
            }
            s.push(new int[]{arr[i] , i});
        }
        return nlri;
    }
    public long subArrayRanges(int[] nums) {
        int[] nsli = NSL(nums);
        int[] nsri = NSR(nums);
        long min = 0;
        for(int i = 0; i < nums.length; i++){
            long d = (Math.abs(nsli[i]-i)*Math.abs(nsri[i]-i));
            long v = (d*nums[i]);
            min = (min+v);
        }
        int[] nlli = NLL(nums);
        int[] nlri = NLR(nums);
        long max = 0;
        for(int i = 0; i < nums.length; i++){
            long d = (Math.abs(nlli[i]-i)*Math.abs(nlri[i]-i));
            long v = (d*nums[i]);
            max = (max+v);
        }
        return max-min;
    }
}