import java.util.HashMap;
import java.util.Map;

public class IntersectionAndCollision {


    public static String maxCollision(String [] roads){

        Map<String, Integer> map = new HashMap<>();
  
        for(String road : roads){
            map.put(road, map.getOrDefault(road, 0) + 1 );
        }

        int maxCollision=0;
        String maxCollisionRoad="";
        //Map.Entry<String, Integer> result = new Map.E;
        for (Map.Entry<String,Integer> e: map.entrySet()) {

            if(e.getValue() >maxCollision){
                maxCollision = e.getValue();
                maxCollisionRoad = e.getKey();
            }  
        }
        return maxCollisionRoad + " has " + maxCollision + "collisisons" ;
    }


    public static void main(String[] args) {
        String[] roads = {"Main Street", "Broadway", "Main Street", "1st Avenue", "Broadway", "Main Street"};
        System.out.println(maxCollision(roads));

        String[] roads2 = {"King Road", "Queen Street", "Queen Street", "King Road", "King Road"};
        System.out.println(maxCollision(roads2));

        


    }
    
}
