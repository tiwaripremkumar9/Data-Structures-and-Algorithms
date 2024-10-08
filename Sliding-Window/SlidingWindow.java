/*
 * Th best Example to understand the Sliding Window technique is to 
 * understand the solution of "Maximum Sum Subarray of given length k". 
 */

 /**
  * SlidingWindow
  */
 public class SlidingWindow {

    /*
     * Below Approach is code of my first try of sliding Algo
     */
    public static int slidingWindow(int [] arr, int k) {
        if(k > arr.length) {
            return -1;
        }
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        
        int maxSum = sum;
        if(k == arr.length) {
            return sum;
        }
        
        for(int i = k; i < arr.length; i++) {
            //sum = sum + arr[i] - arr[i - k];
            //rewriting above as shorthand
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
	}


 
    public static void main(String[] args) {
        int [] arr = {1,5,4,100,9,9,9};
    	//int [] arr = {1,2,4,5,4,1};
       System.out.println(slidingWindow(arr,2));
    }
 }