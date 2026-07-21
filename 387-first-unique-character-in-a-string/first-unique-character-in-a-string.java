class Solution {
    public int firstUniqChar(String s) {
        char[] letter = s.toCharArray();
        
        for (int i = 0; i < letter.length; i++) {
            boolean isUnique = true;
            
            for (int j = 0; j < letter.length; j++) { 
                if (i != j && letter[i] == letter[j]) {
                    isUnique = false; 
                    break;            
                }
            }
             
            if (isUnique) {
                return i;
            }
        }
        
        return -1; 
    }
}