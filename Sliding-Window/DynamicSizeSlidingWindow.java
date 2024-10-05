/*
 * The best problem to understand Dynamic/Variable size sliding window is:
 * 
 * Find the Minimum size subarray with given sum.
 * 
 * Concept:

The sliding window technique involves creating a “window” that slides over the data structure (like an array or string) to perform operations on subsets of the data.
In a dynamic size sliding window, the window can expand or contract based on certain conditions, unlike a fixed-size window that remains constant.
Steps:

Initialize Pointers: Start with two pointers, typically left and right, both set at the beginning of the data structure.
Expand the Window: Move the right pointer to expand the window by including more elements until a certain condition is met.
Contract the Window: If the condition is violated, move the left pointer to shrink the window until the condition is satisfied again.
Update Results: During each expansion or contraction, update the results based on the problem’s requirements (e.g., maximum sum, longest substring, etc.).
Example: Let’s say you want to find the longest substring with all unique characters in a given string.

Initialize: Set left and right pointers at the start of the string. Use a set to track unique characters.
Expand: Move the right pointer to include characters in the window. Add each character to the set.
Contract: If a duplicate character is found, move the left pointer to remove characters from the window until all characters are unique again.
Track Maximum Length: Keep track of the maximum length of the window during the process
 */



public class DynamicSizeSlidingWindow {
    
    public static int dynamicSizeSlidingWindow(int target, int[] nums) {
        int l = nums.length;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        
        for(int windowEnd = 0; windowEnd < l; windowEnd++) {
            currentSum += nums[windowEnd];
            
                while(currentSum > target) {
                    currentSum -= nums[windowStart];
                    windowStart++;
                }

            if(currentSum == target) {
                int subarrayLength = windowEnd - windowStart + 1;
                minLength = Math.min(minLength, subarrayLength);
            }
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

public static void main(String[] args) {
    //int [] arr = {1,5,4,2,9,9,9};
    int [] arr = {3,1,4,2,0,6,1,7,8,6,5,4,5,9,9};
   System.out.println(dynamicSizeSlidingWindow(18,arr));
}
}
