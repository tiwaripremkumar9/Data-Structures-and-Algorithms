package TwoPointers.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Brute force solution

    // public static int[] twoSum(int[] numbers, int target) {
    //     int [] result = new int[2];
    //     boolean found = false;
    //     for(int i = 0; i < numbers.length; i++){
    //         for(int j = i+1; j < numbers.length; j++){
    //             if(numbers[i] + numbers[j] == target){
    //                 result[0] = i;
    //                 result[1] = j;
    //                 found = true;
    //                 break;
    //             }
                
    //         }
    //         if(found){
    //             break;
    //         }
    //     }

    //     if(!found){
    //         result[0] = -1;
    //         result[1] = -1;
    //     }

    //     return result;
        
    // }

    // Optimized Approach (returns indices)

    public static int [] twoSum(int[] numbers, int target){

        int [] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbers.length; i++){
            int complement = Math.abs(target - numbers[i]);
            if(map.containsKey(complement)){
                result[0] = map.get(complement);
                result[1] = i;
                break;
            }
            map.put(numbers[i], i);
        }

        return result;

    }

    // Optimized Approach - But doesn't return indices - returns the sum numbers
    // [2,5,7,8,9,14]
    public static int[] twoSumTwoPointers(int [] numbers, int target){
        int [] result = {-1, -1};
        Arrays.sort(numbers);
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum < target){
                i++;
            }
            else if (sum > target){
                j--;
            }
            // sum found
            else{
                result [0] = numbers[i];
                result [1] = numbers[j];
                break;
            }
        }

        return result;


    }


    // Optimized Approach
    public static void main(String[] args) {
        int [] numbers = {1,5,7,8,9,14};
        int target = 12;
        int [] resultArray = twoSumTwoPointers(numbers, target);
        System.out.println(Arrays.toString(resultArray));
        
    }
}
