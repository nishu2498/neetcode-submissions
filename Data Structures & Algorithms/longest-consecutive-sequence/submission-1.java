class Solution {
    public int longestConsecutive(int[] nums) {
        
        // create an empty hashSet
        HashSet<Integer> numSet = new HashSet<>();

        // add numbers in that hashset
        for (int num: nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num: numSet) {
            // check if we did not find current number - 1 element in hashset
            // which means that current element could be start of subsequence, hence
            // we must count the length
            if (!numSet.contains(num - 1)) {
                int length = 1;
                // check till what length now we can find the subsequence, since we know the start
                while(numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
