class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // start with 3 arrays of size of nums, named prefix, suffix and resultant
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] resultant = new int[len];

        // setting both the starting points of both arrays to 1
        prefix[0] = 1; // nothing to the left of index 0
        suffix[len-1] = 1; // nothing to the right of last index

        // build the prefix array
        for (int i=1; i<len; i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        // build the suffix array
        for (int i = len-2; i >= 0; i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        // build the result in resultant array
        for (int i=0; i<len; i++) {
            resultant[i] = prefix[i] * suffix[i];
        }

        return resultant;
    }
}  
