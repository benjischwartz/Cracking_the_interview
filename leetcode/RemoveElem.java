class RemoveElem {
    public int removeElement(int[] nums, int val) {
        
        
        // Count number of elements to remove
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            }
        }
        
        // If an element is == val, swap with nearest non-val element
        for (int j = 0; j < nums.length - count; j++) {
            if (nums[j] == val) {
                for (int k = (j + 1); k < nums.length; k++) {
                    if (nums[k] != val) {
                        nums[j] = nums[k];
                        nums[k] = val;
                        break;
                    }
                }
            }
        }
        return nums.length - count;
    }
}
