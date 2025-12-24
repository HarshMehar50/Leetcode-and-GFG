import java.util.Arrays;
class Solution {
    int sum(int[] arr){
        int s = 0;
        for(int i = 0; i < arr.length; i++){
            s = s + arr[i];
}
        return s;
}
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int s = sum(apple);
        int c = 0;
        int r = 0;
        for(int i = capacity.length-1; i >= 0; i--){
            r = r + capacity[i];
            c++;
            if(r >= s)
                break;
        }
        return c;
    }
}