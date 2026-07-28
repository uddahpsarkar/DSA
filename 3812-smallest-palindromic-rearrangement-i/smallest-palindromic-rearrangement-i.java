class Solution {
    public static String smallestPalindrome(String s) {
        // if (s == null || s.length() < 4) {
        //     return s;
        // }
 
        // char[] chars = s.toCharArray();
        // int n = chars.length;
        // int mid = n / 2;
 
        // for (int i = 0; i < mid - 1; i++) { 
        //     char temp = chars[i];
        //     chars[i] = chars[i + 1];
        //     chars[i + 1] = temp;
        // }
 
        // for (int j = n - 1; j > mid; j--) { 
        //     char temp = chars[j];
        //     chars[j] = chars[j - 1];
        //     chars[j - 1] = temp;
        // }
 
        // return new String(chars); 
        
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder leftHalf = new StringBuilder();
        char midChar = 0;
 
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            int halfCount = freq[i] / 2;
            char ch = (char) ('a' + i);

            for (int j = 0; j < halfCount; j++) {
                leftHalf.append(ch);
            }
 
            if (freq[i] % 2 != 0) {
                midChar = ch;
            }
        }
 
        StringBuilder result = new StringBuilder(leftHalf);
        if (midChar != 0) {
            result.append(midChar);
        }
        result.append(new StringBuilder(leftHalf).reverse());

        return result.toString();
    }
}