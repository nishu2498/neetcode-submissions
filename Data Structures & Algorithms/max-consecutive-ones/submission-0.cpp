class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        
        int maxNums = 0;
        int currentNum = 0;
        for (int i=0; i<nums.size(); i++) {
            if (nums[i] == 1) {
                currentNum++;
                maxNums = max(maxNums, currentNum);
            } else {
                currentNum = 0;
            }
        }
        return maxNums;
    }
};