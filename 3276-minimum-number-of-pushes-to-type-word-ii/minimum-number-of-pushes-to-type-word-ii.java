import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        
        Arrays.sort(count);
        
        int totalPushes = 0;
        int multiplier = 1;
        int countKeys = 0;
        
        // Iterate from the highest frequency character to the lowest
        for (int i = 25; i >= 0; i--) {
            if (count[i] == 0) {
                break;
            }
            totalPushes += count[i] * multiplier;
            countKeys++;
            
            // Every 8 characters, we move to the next set of pushes on the keys (e.g., from 1 press to 2 presses)
            if (countKeys % 8 == 0) {
                multiplier++;
            }
        }
        
        return totalPushes;
    }
}