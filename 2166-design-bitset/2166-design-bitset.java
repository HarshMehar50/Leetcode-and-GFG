class Bitset {
    int[] bitset;
    int fc;
    int c;
    StringBuilder sb;
    public Bitset(int size) {
        bitset = new int[size];
        sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append('0');
        }
        fc = 0;
        c = 0;
    }
    
    public void fix(int idx) {
        int bit = bitset[idx];
        if(fc%2 != 0)
        bit = 1-bit;
        if(bit == 0){
            if(fc%2 == 0){
                bitset[idx] = 1;
                sb.setCharAt(idx , '1');
            }else{
                bitset[idx] = 0;
                sb.setCharAt(idx , '0');
            }
            c++;
        }
    }
    
    public void unfix(int idx) {
        int bit = bitset[idx];
        if(fc%2 != 0)
        bit = 1-bit;
        if(bit == 1){
            if(fc%2 == 0){
                bitset[idx] = 0;
                sb.setCharAt(idx , '0');
            }else{
                bitset[idx] = 1;
                sb.setCharAt(idx , '1');
            }
            c--;
        }
    }
    
    public void flip() {
        fc++;
        c = bitset.length-c;
    }
    
    public boolean all() {
        return c == bitset.length;
    }
    
    public boolean one() {
        return c > 0;
    }
    
    public int count() {
        return c;
    }
    
    public String toString() {
        if(fc%2 == 0)
        return sb.toString();
        StringBuilder sb1 = new StringBuilder(sb);
        for(int i = 0; i < sb1.length(); i++){
            if(sb1.charAt(i) == '0')
            sb1.setCharAt(i , '1');
            else
            sb1.setCharAt(i , '0');
        }
        return sb1.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */