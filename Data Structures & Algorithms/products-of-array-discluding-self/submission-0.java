class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // we need to handle one edge case where there could be more than 1 zero, we are using InStream class for practise purpose
        if (IntStream.of(nums).filter(num->num == 0).count() >= 2) {
            return new int[nums.length];
        }

        int prodNums = 1;
        int countZeros = 0;

        for (int num: nums) {

            // if we detect zero, skip multiplying to find product of array
            if (num == 0) {
                countZeros++;
                continue;
            }

            // find out the product of complete array
            prodNums = prodNums * num;
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0 && countZeros > 0) {
                nums[i] = 0;
            } else if (nums[i] != 0 && countZeros == 0) {
                nums[i] = prodNums / nums[i];
            } else {
                nums[i] = prodNums;
            }
        }

        return nums;
    }
}  
