class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }

        int start = 0;
        int last = s.length()-1;

        while(start<=last){
            char charFirst = s.charAt(start);
            char charLasrt = s.charAt(last);

            if(!Character.isLetterOrDigit(charLasrt)){
                last--;
            }else if(!Character.isLetterOrDigit(charFirst)){
                start++;
            }else{
                if(Character.toLowerCase(charFirst) != Character.toLowerCase(charLasrt)){
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}