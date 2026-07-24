class Solution {
    public String reverseOnlyLetters(String s) { 
        char[] charArray = s.toCharArray(); 
        int left = 0;
        int right = charArray.length - 1; 
        while (left < right) { 
            while (left < right && !Character.isLetter(charArray[left])) {
                left++;
            } 
            while (left < right && !Character.isLetter(charArray[right])) {
                right--;
            }
           
            if (left < right) { 
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
               
                left++;
                right--;
            }
        }
       
        return new String(charArray);
    }
}