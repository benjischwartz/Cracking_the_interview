// You are a professional robber planning to rob houses along 
// a street. Each house has a certain amount of money stashed, 
// the only constraint stopping you from robbing each of them 
// is that adjacent houses have security systems connected and 
// it will automatically contact the police if two adjacent 
// houses were broken into on the same night.

// Given an integer array nums representing the amount of money 
// of each house, return the maximum amount of money you can 
// rob tonight without alerting the police.

class HouseRobber {
    // DP strategy
    // Recursion: opt(i) = max{opt(i - 1), opt(i - 2) + nums[i]};
    // Base Case: opt(-1) = 0; Return: opt(nums.length)
    
    public int rob(int[] nums) {
        if (nums.length < 3) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 0) {
                return 0;
            }
            else {
                return Math.max(nums[0], nums[1]);
            }
        } else {
            int[] subOne = new int[nums.length - 1];
            int[] subTwo = new int[nums.length - 2];
            subOne = Arrays.copyOfRange(nums, 0, nums.length - 1);
            subTwo = Arrays.copyOfRange(nums, 0, nums.length - 2);
            return Math.max(rob(subOne), rob(subTwo) + nums[nums.length - 1]);
        }
    }
}
    
