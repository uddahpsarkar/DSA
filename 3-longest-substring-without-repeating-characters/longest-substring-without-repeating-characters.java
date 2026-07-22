class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ran = s.toCharArray();
        int max = 0;
 
        for (int i = 0; i < ran.length; i++) {
            int count = 0;
            boolean[] seen = new boolean[128]; 

            for (int j = i; j < ran.length; j++) {
                 
                if (seen[ran[j]]) {
                    break;
                }
                
                seen[ran[j]] = true;
                count++;
            }
 
            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}