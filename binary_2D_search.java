public class binary_2D_search {

    public static boolean binarySearch(int[][]matrix, int target){

        int lengthColumn = matrix.length, lengthRow = matrix[0].length;

        int top =0,bottom=lengthColumn-1;
        int row=0;
        while(top<=bottom){
            row = (top+bottom)/2;
            if(target < matrix[row][0]){
                bottom=row-1;  
            }
            else if(target> matrix[row][lengthRow-1]){
                top = row +1;
            }
            else{
                break;
            }
        }
        if(!(top<=bottom)){
            return false;
        }
        
        int left = 0, right = lengthRow-1;
        int mid;
        while(left<=right){
            mid = (left+right)/2;
            if (matrix[row][mid] == target){
                return true;
            }
            else if(target> matrix[row][mid]){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        // Test cases
        int[][] matrix1 = {
                {1, 3, 5},
                {7, 10, 12},
                {14, 16, 18}
        };
        System.out.println(binarySearch(matrix1, 10)); // Expected: true
        System.out.println(binarySearch(matrix1, 1)); // Expected: true
        System.out.println(binarySearch(matrix1, 18)); // Expected: true
        System.out.println(binarySearch(matrix1, 13)); // Expected: false
    }
    
}
