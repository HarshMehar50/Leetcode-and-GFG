class Solution {
    void DFS(int r , int c , int[][] copy , int[][] image , int color , int[] deltaR , int[] deltaC , int initialColor){
        copy[r][c] = color;
        for(int i = 0; i < 4; i++){
            int nr = r+deltaR[i];
            int nc = c+deltaC[i];
            if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == initialColor && copy[nr][nc] != color){
                DFS(nr , nc , copy , image , color , deltaR , deltaC , initialColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] copy = new int[image.length][image[0].length];
        copy = image;
        int[] deltaR = {-1 , 0 , 1 , 0};
        int[] deltaC = {0 , 1 , 0 , -1};
        int initialColor = image[sr][sc];
        DFS(sr , sc , copy , image , color , deltaR , deltaC , initialColor);
        return copy;
    }
}