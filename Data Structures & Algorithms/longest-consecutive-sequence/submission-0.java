class Solution {
    public int longestConsecutive(int[] nums) {
        
        // check if nums is empty or not
        if (nums.length == 0) {
            return 0;
        }

        // fill in hashset with numbers
        HashSet<Integer> numSet = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            numSet.add(nums[i]);
        }

        // initialize global subsequence variable
        int longestSubsequence = 1;

        // check whether one element less than current exists to find the start of common subsequence
        for (int num: numSet) {
            if (numSet.contains(num - 1)) {
                // means there exists a smaller element, which could be start of subsequence
                continue;
            } else {
                int currentNum = num;
                int currentMaxSubsequence = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentMaxSubsequence++;
                }

                // Check if we have found largest common subsequence or not
                longestSubsequence = Math.max(longestSubsequence, currentMaxSubsequence);
            }
        }

        return longestSubsequence;
    }
}
