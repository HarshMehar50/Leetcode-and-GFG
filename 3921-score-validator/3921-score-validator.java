class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0;
        for(String s : events){
            if(counter == 10)
            break;
            if(s.charAt(0)-'0' >= 0 && s.charAt(0)-'0' <= 6)
            score += s.charAt(0)-'0';
            else if(s.charAt(0) == 'W' && s.length() == 1)
            counter++;
            else if(s.charAt(0) == 'W' && s.charAt(1) == 'D')
            score++;
            else score++;
        }
        return new int[]{score , counter};
    }
}