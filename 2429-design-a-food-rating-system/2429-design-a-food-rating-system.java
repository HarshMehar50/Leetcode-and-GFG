class FoodRatings {
    class tuple{
        String food;
        String cuisine;
        int rating;
        public tuple(String food , String cuisine , int rating){
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
    class pair{
        String food;
        int rating;
        public pair(String food , int rating){
            this.food = food;
            this.rating = rating;
        }
    }
    tuple[] global;
    HashMap<String , Integer> map;
    TreeMap<String , TreeSet<pair>> mapts;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        global = new tuple[foods.length];
        map = new HashMap<>();
        mapts = new TreeMap<>();
        for(int i = 0; i < cuisines.length; i++){
            mapts.put(cuisines[i] , new TreeSet<>((x , y)->(x.rating != y.rating)?Integer.compare(y.rating , x.rating):x.food.compareTo(y.food)));
        }
        for(int i = 0; i < foods.length; i++){
            global[i] = new tuple(foods[i] , cuisines[i] , ratings[i]);
            mapts.get(cuisines[i]).add(new pair(foods[i] , ratings[i]));
            map.put(global[i].food , i);
        }
    }
    
    public void changeRating(String food, int newRating) {
        int pr = global[map.get(food)].rating;
        String c = global[map.get(food)].cuisine;
        mapts.get(c).remove(new pair(food , pr));
        mapts.get(c).add(new pair(food , newRating));
        global[map.get(food)].rating = newRating;
    }
    
    public String highestRated(String cuisine) {
        String ans = mapts.get(cuisine).first().food;
        return ans;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */