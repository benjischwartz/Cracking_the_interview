


public class Contig {

    public static int getIdx (int[] arr, int length) {
        // Get first element
        // Get the middle idx; mid = length/2
        // while (A[mid] == A[mid+1])
        //      Check if A[mid] == first
        //              mid = mid + length /2
        //      else
        //              mid = mid/2
        
        length = length - 1; 
        int first = arr[0];
        int mid = length/2;
        while (arr[mid] == arr[mid + 1]) {
            if (arr[mid] == first) {
                mid = (mid + length)/2;
            }
            else {
                mid = mid/2;
            }
        }
        return mid; 

        
    }

    public static void main(String[] args) {
        int[] testArr = {1, 1, 1, 1, 1, 2};
        System.out.println(getIdx(testArr, 6));
    }
}
