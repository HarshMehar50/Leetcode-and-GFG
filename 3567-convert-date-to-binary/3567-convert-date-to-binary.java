class Solution {
    public String convertDateToBinary(String date) {
        String y = date.substring(0 , 4);
        String m = date.substring(5 , 7);
        String d = date.substring(8 , 10);
        int y1 = Integer.parseInt(y);
        int m1 = Integer.parseInt(m);
        int d1 = Integer.parseInt(d);
        String by = Integer.toBinaryString(y1);
        String bm = Integer.toBinaryString(m1);
        String bd = Integer.toBinaryString(d1);
        return by+'-'+bm+'-'+bd;
    }
}