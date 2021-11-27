class RemoveElem {
    public int removeElement(int[] nums, int val) {
        
        // Check for empty array
        if (nums.length == 0) {
            return 0;
        }
        
        // Check if 1 element
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } return 1;
        }
        
        int counter = 0;
        int repeats = 0;
        
        // Get count of repeats
        int r = 0;
        for (int c = 0; c < nums.length; c++) {
            if (nums[c] == val) {
                r++;
            }
        }
        for (int i = 0; i < nums.length - r + 1; i++) {
            if (nums[i] == val) {
                repeats++;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == val) {
                        repeats++;
                    } else {
                        break;
                    }
                }
                
                // Shift array down by 'repeats'
                for (int k = i; k < nums.length - repeats; k++) {
                    nums[k] = nums[k + repeats];
                }
            }    
        }
        return nums.length - r;
    }
}
