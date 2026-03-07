class FrequencyTracker {
    TreeMap<Integer , Integer> f;
    TreeMap<Integer , Integer> fc;
    public FrequencyTracker() {
        f = new TreeMap<>();
        fc = new TreeMap<>();
    }
    
    public void add(int number) {
        int pv = f.getOrDefault(number , 0);
        f.put(number , pv+1);
        int nv = f.get(number);
        if(pv != 0){
            fc.put(pv , fc.get(pv)-1);
            if(fc.get(pv) == 0)
            fc.remove(pv);
        }
        fc.put(nv , fc.getOrDefault(nv , 0)+1);
    }
    
    public void deleteOne(int number) {
        if(f.containsKey(number)){
            int pv = f.get(number);
            f.put(number , pv-1);
            int nv = f.get(number);
            if(nv == 0)
            f.remove(number);
            fc.put(pv , fc.get(pv)-1);
            if(fc.get(pv) == 0)
            fc.remove(pv);
            f.put(nv , fc.getOrDefault(nv , 0)+1);
        }
        /*if(!f.containsKey(number))
            return;

        int pv = f.get(number);
        int nv = pv - 1;

        fc.put(pv , fc.get(pv) - 1);
        if(fc.get(pv) == 0)
            fc.remove(pv);

        if(nv == 0){
            f.remove(number);
        } else {
            f.put(number , nv);
            fc.put(nv , fc.getOrDefault(nv , 0) + 1);
        }*/
    }
    
    public boolean hasFrequency(int frequency) {
        return fc.containsKey(frequency);
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */