##### KADANE'S ALGORITHM

**Kadane's Algorithm** is a popular algorithm used to solve the **Maximum Subarray Problem**. The problem is to find the contiguous subarray within a one-dimensional array of numbers which has the largest sum.

#### Key Concepts:
1. **Dynamic Programming**: Kadane's Algorithm uses a dynamic programming approach to solve the problem efficiently.
2. **Variables**:
   - `maxEndingHere`: Tracks the maximum sum of the subarray ending at the current position.
   - `maxSoFar`: Tracks the maximum sum encountered so far across all subarrays.

#### Steps:
1. Initialize `maxEndingHere` and `maxSoFar` to the first element of the array.
2. Iterate through the array starting from the second element.
3. For each element, update `maxEndingHere` to be the maximum of the current element and the sum of `maxEndingHere` and the current element.
4. Update `maxSoFar` to be the maximum of `maxSoFar` and `maxEndingHere`.
5. After completing the iteration, `maxSoFar` will contain the maximum sum of the contiguous subarray.

### Java Code:

```java
public class KadaneAlgorithm {
    public static int maxSubarraySum(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum contiguous sum is " + maxSubarraySum(nums));
    }
}
```

### Explanation:
- **Initialization**: `maxEndingHere` and `maxSoFar` are initialized to the first element of the array.
- **Iteration**: The loop starts from the second element. For each element, `maxEndingHere` is updated to be the maximum of the current element and the sum of `maxEndingHere` and the current element. This step decides whether to start a new subarray at the current element or to continue with the existing subarray.
- **Update `maxSoFar`**: After updating `maxEndingHere`, `maxSoFar` is updated to be the maximum of `maxSoFar` and `maxEndingHere`. This ensures that `maxSoFar` always holds the maximum sum encountered so far.
- **Result**: After the loop, `maxSoFar` contains the maximum sum of the contiguous subarray.

This algorithm runs in O(n) time complexity, making it very efficient for large arrays.