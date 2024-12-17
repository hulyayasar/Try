public class CountCollisionsOnARoad {



    public static int countCollisions(String directions) {

        //directions = "RLRSLL"
        //"LLRLRLLSLRLLSLSSSS" expected 10 but 14
        int collision = 0;
        if(directions.length()>=2){

            int pointer1 = 0;
            for(int pointer2= 1; pointer2< directions.length(); pointer2++){

                if(directions.charAt(pointer1) == 'R'){
                    if(directions.charAt(pointer2) == 'R'){
                   
                    }else if(directions.charAt(pointer2) == 'L'){
                        collision+=2;
                        
                        directions = directions.substring(0, pointer2) + "X" + directions.substring(pointer2+1, directions.length());

                    }else{
                        collision++; 
                        directions = directions.substring(0, pointer2) + "X" + directions.substring(pointer2+1, directions.length());
                    }

                }
                else if((directions.charAt(pointer1) == 'S' || directions.charAt(pointer1) == 'X')
                        && (directions.charAt(pointer2) == 'L')){
                    collision++; 
                    directions = directions.substring(0, pointer2) + "X" + directions.substring(pointer2+1, directions.length());
                }

                pointer1 = pointer2;
            }
        }
        return collision; 
    } 

    public static int countCollisions_2(String directions) {

        int pointer = 0;
        int carFromLeft = 0;
        int collision = 0;

        while (pointer<directions.length() && directions.charAt(pointer) == 'L') {
            pointer++;        
        }
        for ( ; pointer < directions.length(); pointer++) {

            if(directions.charAt(pointer) == 'R'){
                carFromLeft++;
            }
            else if(directions.charAt(pointer) == 'S'){
                collision = collision + carFromLeft;
                carFromLeft=0;
            }else{
                collision = collision + carFromLeft + 1 ;
                carFromLeft=0;
            }       
        }
        return collision;
    }

    public static void main(String[] args) {
        String s = "LLRLRLLSLRLLSLSSSS";
        System.out.println(countCollisions_2(s)); // 10
        String s2 = "RLRSLL";
        System.out.println(countCollisions_2(s2)); // 5
        String s3= "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
        System.out.println(countCollisions_2(s3)); // 20
        String s4= "L";
        System.out.println(countCollisions_2(s4)); // 0

    }
}
