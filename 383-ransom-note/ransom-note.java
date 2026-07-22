class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ran = ransomNote.toCharArray();
        char[] mar = magazine.toCharArray();
        
        for(int i=0; i<ran.length;i++){
        boolean result = false; 
            for(int j=0; j<mar.length;j++){
                 if(ran[i] == mar[j]){
                    result = true;
                    mar[j] = ' ';
                    break;
                 }
            } 
            if(!result){
                return false;
            }
        } 
        return true;
    }
}