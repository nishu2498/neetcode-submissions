class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        // Create a hashset
        HashSet<Integer> seenElements = new HashSet<>();

        // Iterate through the array
        for (int num: nums) {
            // if element is present in hashset using contains method
            if (seenElements.contains(num)) {
                return true;
            }
            // If that element is not present in hashset, we add it,since it is unique
            seenElements.add(num);
        }

        // If we reach here, that's end of adding elements in hashset, we return false
        return false;
    }
}