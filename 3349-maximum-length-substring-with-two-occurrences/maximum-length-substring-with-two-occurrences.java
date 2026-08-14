class Solution {
    public int maximumLengthSubstring(String s) {
        // Array to keep track of the frequency of each character in the current window
        int[] count = new int[26]; 
        int left = 0;
        int maxLength = 0;
        
        // Expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            count[currentChar - 'a']++;
            
            // If the current character appears more than twice, shrink the window from the left
            while (count[currentChar - 'a'] > 2) {
                char leftChar = s.charAt(left);
                count[leftChar - 'a']--;
                left++;
            }
            
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}