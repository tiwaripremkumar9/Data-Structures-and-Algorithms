package BinarySearch;

/**
 * BinarySearch
 */
public class BinarySearch {

    public static int binarySearch(int [] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] == key){
                index = mid;
                break;
            }
            if(arr[mid] > key){
                high = mid - 1;
            }
            if(arr[mid] < key){
                low = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr, 7));
    }
}