class Solution {
    int gcd(int a, int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> s = new Stack<>();
        /*int i = 0;
        while(i < nums.length){
            while(i < nums.length && !s.isEmpty() && gcd(s.peek() , nums[i]) > 1){
                int a = s.pop();
                int b = nums[i];
                int ne = (a*b)/gcd(a , b);
                s.push(ne);
                i++;
            }
            if(i < nums.length){
            s.push(nums[i]);
            i++;
            }
        }*/
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            while(!s.isEmpty() && gcd(x , s.peek()) > 1){
                int a = s.pop();
                int g = gcd(a , x);
                x = (a/g)*x;
            }
            s.push(x);
        }
        List<Integer> l = new ArrayList<>(s);
        /*while(!s.isEmpty()){
            l.add(s.pop());
        }
        Collections.reverse(l);*/
        return l;
    }
}