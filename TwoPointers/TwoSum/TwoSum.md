# Two Sum — DSA Revision Notes

## Problem
Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`. Assume exactly one solution exists, and you may not use the same element twice.

---

## 1. Brute Force Approach

**Explanation (simple words):**
Check every possible pair of numbers in the array. For each number, compare it with every other number after it, and see if the two add up to the target. If they do, return their indices.

**Java Code:**
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] {}; // no solution found
    }
}
```

**Time Complexity:** O(n²) — for every element, we scan the rest of the array to find a matching pair (nested loop).

**Space Complexity:** O(1) — no extra data structure used, only constant extra variables.

---

## 2. HashMap Approach

**Explanation (simple words):**
Instead of checking every pair, walk through the array once. For each number, calculate what value we still need (`target - current number`) — call this the "complement." Check if that complement was already seen before (stored in a hashmap along with its index). If yes, we found our pair. If no, add the current number to the hashmap and move on.

**Java Code:**
```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {}; // no solution found
    }
}
```

**Time Complexity:** O(n) — single pass through the array; hashmap lookup/insert is O(1) on average.

**Space Complexity:** O(n) — hashmap can store up to n elements.

---

## 3. Two Pointer Approach

**Explanation (simple words):**
This approach works best when the array is **sorted**. Since the original Two Sum problem has an *unsorted* array and expects the *original indices*, we first pair each number with its original index, then sort by value. Once sorted, use two pointers — one starting at the beginning (`left`), one at the end (`right`) — and move them based on the sum:
- If the sum is too small, move `left` forward (increase sum).
- If the sum is too large, move `right` backward (decrease sum).
- If it matches the target, return the original indices.

**Java Code:**
```java
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // pair each value with its original index: [value, originalIndex]
        int[][] indexedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedNums[i][0] = nums[i];
            indexedNums[i][1] = i;
        }

        // sort by value
        Arrays.sort(indexedNums, (a, b) -> a[0] - b[0]);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = indexedNums[left][0] + indexedNums[right][0];

            if (sum == target) {
                return new int[] { indexedNums[left][1], indexedNums[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {}; // no solution found
    }
}
```

**Time Complexity:** O(n log n) — dominated by the sorting step; the two-pointer scan itself is only O(n).

**Space Complexity:** O(n) — extra space to store value-index pairs.

---

## Comparison Summary

| Approach     | Time Complexity | Space Complexity | Notes |
|--------------|------------------|-------------------|-------|
| Brute Force  | O(n²)            | O(1)              | Simple but slow, avoid in interviews if better exists |
| HashMap      | O(n)             | O(n)              | Best for this problem — unsorted array, need original indices |
| Two Pointer  | O(n log n)       | O(n)              | Only worth it if array is already sorted (sorting cost avoided) |

## Key Takeaway
HashMap is the optimal solution for the classic (unsorted) Two Sum. Two Pointers becomes the better choice — O(n) time, O(1) space — only when the input array is **already sorted**, as in Two Sum II.