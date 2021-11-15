import java.lang.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        
        // search space for k
        int right = max;
        int left = 1;
        int mid = 0;
        
        while (left <= right) {
            
            mid = Math.floorDiv((left + right), 2);
            
            // Found condition
            if (calculateTime(piles, mid) <= h && calculateTime(piles, mid - 1) > h) {
                return mid;
            }
            
            // Go left
            if (calculateTime(piles, mid) <= h) {
                right = mid - 1;
            }
            
            // Go right
            else {
                left = mid + 1;
            }
        }
        return 0;
    }
    
    public int calculateTime(int[] piles, int k) {
        
        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHours += Math.ceil(((double) piles[i])/k);
        }
        
        return totalHours;
    }
}
