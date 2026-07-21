class Solution {
    public int mostWordsFound(String[] sentences) {
        
        int temp = 0;
        for (String sentence : sentences) { 
            String[] words = sentence.split(" ");
            if(temp < words.length){
                temp = words.length;   
            }
        }
        return temp;
    }
}