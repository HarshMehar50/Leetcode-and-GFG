class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0.0;
        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                for(int k = j+1; k < points.length; k++){
                    /*double a = Math.sqrt(Math.pow(points[i][0]-points[j][0] , 2)+Math.pow(points[i][1]-points[j][1] , 2));
                    double b = Math.sqrt(Math.pow(points[j][0]-points[k][0] , 2)+Math.pow(points[j][1]-points[k][1] , 2));
                    double c = Math.sqrt(Math.pow(points[i][0]-points[k][0] , 2)+Math.pow(points[i][1]-points[k][1] , 2));
                    double s = (double)((a+b+c)/2.0);
                    double area = s*(s-a)*(s-b)*(s-c);
                    ans = Math.max(ans , Math.sqrt(area));*/
                    double area = Math.abs(points[i][0]*(points[j][1]-points[k][1]) + points[j][0]*(points[k][1]-points[i][1]) + points[k][0]*(points[i][1]-points[j][1]))/2.0;
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }
}