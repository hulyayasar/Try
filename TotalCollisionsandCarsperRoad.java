import java.util.HashMap;
import java.util.Map;

public class TotalCollisionsandCarsperRoad {

    public static String maxCollisionAndCars(String[]roads,int[] cars){

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> carPerRoad = new HashMap<>();

        for(int i =0; i< roads.length; i++){
            map.put(roads[i], map.getOrDefault(roads[i],0) +1);
            carPerRoad.put(roads[i], carPerRoad.getOrDefault(roads[i],0) + cars[i]);
        }

        int maxColission = 0;
        String maxCollisionRoad = "";
        int CarNumber = 0;

        for(Map.Entry<String,Integer> e: map.entrySet()){

            if(e.getValue()> maxColission){
                maxColission = e.getValue();
                maxCollisionRoad = e.getKey();
                CarNumber = carPerRoad.get(e.getKey());
            }
        }

        return maxCollisionRoad + " has " + maxColission + " collision and numer of car on the road is " + CarNumber;
    }

    public static void main(String[] args) {

        String[] roads = {"Main Street", "Broadway", "Main Street", "1st Avenue", "Broadway", "Main Street"};
        int[] cars  = {2, 3, 5, 4, 1, 3};
        System.out.println(maxCollisionAndCars(roads,cars));
    }
    
}
