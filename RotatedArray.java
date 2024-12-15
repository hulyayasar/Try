public class RotatedArray {

    public static int findMin(int[] nums) {

        int l=0, r=nums.length-1;
        int m=0;
        
        while(l<=r){
            m= (l+r)/2;
            if(nums[l]>nums[r]){
                System.out.println("nums[l]=" + nums[l]);
                if(nums[m]>nums[r]){
                    l=m+1;
                    
                    System.out.println("l=m+1=" + l);
                    continue;
                }else{
                    r=m;
                    System.out.println("r=r-1=" + r);
                    continue;
                }             
             }
            else{
                System.out.println("nums[l]=" + nums[l]);
                return nums[l];           
                
            }
        }
        return nums[m];      
    }

    public static void main(String[] args) {
        int [] nums = {3,4,5,6,1,2};
        System.out.println(findMin(nums));
    }
    
}
