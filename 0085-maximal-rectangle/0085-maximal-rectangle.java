class Solution {
    int solve(int[] height){
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for(int i = 0; i <= height.length; i++){
            while(!s.isEmpty() && (i == height.length || height[s.peek()] >= height[i])){
                int h = height[s.peek()];
                s.pop();
                int w = 0;
                if(s.isEmpty())
                w = i;
                else
                w = i-s.peek()-1;
                max = Math.max(max , w*h);
            }
            s.push(i);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1')
                height[j]++;
                else
                height[j] = 0;
            }
            int area = solve(height);
            ans = Math.max(ans , area);
        }
        return ans;
    }
}