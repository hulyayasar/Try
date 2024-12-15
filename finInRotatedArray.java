public class finInRotatedArray {

    public static int search(int[] nums, int target) {


        int l=0, r= nums.length-1;
        while (l<=r) {

            int m= (l+r)/2;
            if(nums[m]==target){
                return m;               
            }

            if(nums[l]>nums[r]){

                if(nums[m]>target){
                    l=m+1;
                }else{
                    r=m-1;
                } 

            }else{
                if(nums[m]<target){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            
        }
        return -1;
        
    }

    public static void main(String[] args) {
        // int [] nums = {3,4,5,6,1,2};
        // System.out.println(search(nums, 1));

        int [] nums = {3,5,6,0,1,2};
        System.out.println(search(nums, 4));

        

    }
    
}
