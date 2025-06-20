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
                while(!s.isEmpty() && s.peek()[0] >= arr[i]){
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
    public int largestRectangleArea(int[] heights) {
        int[] nsli = NSL(heights);
        int[] nsri = NSR(heights);
        /*for(int i = 0; i < heights.length; i++){
            if(nsli[i] == -1)
            nsli[i]++;
            if(nsri[i] == heights.length)
            nsri[i]--;
        }*/
        int ans = 0;
        for(int i = 0; i < heights.length; i++){
            int area = (nsri[i]-nsli[i]-1)*heights[i];
            ans = Math.max(ans , area);
        }
        return ans;
    }
}