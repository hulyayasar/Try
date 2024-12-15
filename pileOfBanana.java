import java.util.Arrays;

public class pileOfBanana {

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        for( int j=1; j<=piles[piles.length-1] ; j++){
  
            int count = 0;
            for(int i=0; i<piles.length; i++){
                if( count> h ){
                    break;
                }
                
                if((piles[i]%j) == 0){
                    count += (piles[i]/j);
                }else{
                    count += (piles[i]/j) + 1;
                }
                    
                
                
            }
            if(!(count> h)) return j;
        }
        return 0;       
          
    }

    public static void main(String[] args) {
        int [] piles = {1,4,3,2};
        int h = 9;
        System.out.println(minEatingSpeed(piles, h));
        
    }

    

    
}
