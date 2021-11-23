class RemoveDupsInPlace {
    public int removeDuplicates(int[] nums) {
        int slowIdx = 0;
        int fastIdx = 0;
        while (fastIdx < nums.length && slowIdx < nums.length) {
            nums[slowIdx] = nums[fastIdx];
            while (fastIdx < nums.length && nums[fastIdx] == nums[slowIdx]) {
                fastIdx++;
            }
            slowIdx++;
        }
        return slowIdx;
    }
}
