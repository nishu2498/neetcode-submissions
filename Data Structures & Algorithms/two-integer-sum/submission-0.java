class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Create a hashmap of integer
        HashMap<Integer, Integer> numToIndex = new HashMap();

        // Iterate through the array
        for (int i=0; i<nums.length; i++) {

            // Calculate the complement of the value
            int complement = target - nums[i];

            // Check if that value is present in hashmap
            if (numToIndex.containsKey(complement)) {

                return new int[] {numToIndex.get(complement), i };
            }

            // Otherwise put the value in hashmap
            numToIndex.put(nums[i], i);
        }

        // If we did not find anything, return empty array
        return new int[] {};
    }
}
