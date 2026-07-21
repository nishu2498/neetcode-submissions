/**
 * Given an array of integers numbers that is sorted in non-decreasing
 * order.
 * Return the indices (1-indexed) of two numbers, [index1, index2], such
 * that they add up to a given target number target and index1 < index2.
 * Note that index1 and index2 cannot be equal, therefore you may not use
 * the same element twice.
 * 
 * There will always be exactly one valid solution
 * 
 * numbers = [1,2,3,4] target = 3
 * Output = [1,2]
 * 
 * We are going to use two pointers, one at the start and the other at
 * the end of the array. If the sum of the numbers at the two pointers is
 * greater than the target, decrement the right pointer, else increment
 * the left pointer. Repeat this process until you find a valid pair.
 * Leetcode_two_integer_sum_2
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            }
            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{start + 1, end + 1};
    }
}